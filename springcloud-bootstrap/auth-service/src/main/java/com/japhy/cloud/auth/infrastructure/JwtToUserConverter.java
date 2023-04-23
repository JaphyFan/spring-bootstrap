package com.japhy.cloud.auth.infrastructure;

/**
 * @author Japhy
 * @since 2023/3/12 04:02
 */

import com.japhy.cloud.auth.entity.User;
import java.util.Collections;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken.TokenType;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class JwtToUserConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        User user = new User();
        user.setId(jwt.getSubject());
        user.setEmail(jwt.getClaim("email"));
        user.setName(jwt.getClaim("name"));
        JwtAuthenticationToken jwtAuthenticationToken =
                new JwtAuthenticationToken(jwt, Collections.emptyList(), user.getId());
        jwtAuthenticationToken.setDetails(user);
        return jwtAuthenticationToken;
        // var defaultOAuth2User =
        //         new DefaultOAuth2User(user.getAuthorities(), jwt.getClaims(), "sub");
        // var oAuth2AccessToken =
        //         new OAuth2AccessToken(TokenType.BEARER, jwt.getTokenValue(), jwt.getIssuedAt(),
        //                 jwt.getExpiresAt(), Collections.emptySet());
        // var bearerTokenAuthentication =
        //         new BearerTokenAuthentication(defaultOAuth2User, oAuth2AccessToken,
        //                 user.getAuthorities());
        // return bearerTokenAuthentication;
    }
}

