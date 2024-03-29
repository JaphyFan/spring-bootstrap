package com.japhy.cloud.auth.infrastructure;


import com.japhy.cloud.auth.entity.User;
import com.japhy.cloud.auth.interfaces.dto.TokenDto;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

@Component
public class TokenProvider {

    @Autowired
    private JwtEncoder jwtEncoder;

    // @Autowired
    // @Qualifier("jwtRefreshTokenEncoder")
    // private JwtEncoder jwtRefreshTokenEncoder;

    private final long expiry = 36000L;

    public String generateAccessToken(final Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("http://127.0.0.1:8081")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject("subject")
                .claim("email", user.getEmail())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String generateRefreshToken(final Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("http://127.0.0.1:8081")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject("subject")
                .claim("email", user.getEmail())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public TokenDto generateToken(Authentication authentication) {
        if (!(authentication.getPrincipal() instanceof User user)) {
            throw new BadCredentialsException(
                    MessageFormat.format("principal {0} is not of User type", authentication.getPrincipal().getClass())
            );
        }

        TokenDto tokenDTO = new TokenDto();
        tokenDTO.setUserId(user.getId());
        tokenDTO.setAccessToken(generateAccessToken(authentication));

        String refreshToken;
        if (authentication.getCredentials() instanceof Jwt jwt) {
            Instant now = Instant.now();
            Instant expiresAt = jwt.getExpiresAt();
            Duration duration = Duration.between(now, expiresAt);
            long daysUntilExpired = duration.toDays();
            if (daysUntilExpired < 7) {
                refreshToken = generateRefreshToken(authentication);
            } else {
                refreshToken = jwt.getTokenValue();
            }
        } else {
            refreshToken = generateRefreshToken(authentication);
        }
        tokenDTO.setRefreshToken(refreshToken);

        return tokenDTO;
    }

}
