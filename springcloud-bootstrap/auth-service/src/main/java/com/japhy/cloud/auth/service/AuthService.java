package com.japhy.cloud.auth.service;

import com.japhy.cloud.auth.infrastructure.TokenProvider;
import com.japhy.cloud.auth.interfaces.dto.LoginRequestDto;
import com.japhy.cloud.auth.interfaces.dto.SignupUserDto;
import com.japhy.cloud.auth.interfaces.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final TokenProvider tokenProvider;

    private final UserService userService;

    private final DaoAuthenticationProvider daoAuthenticationProvider;

    private final JwtAuthenticationProvider refreshTokenAuthProvider;

    public TokenDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = daoAuthenticationProvider.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequestDto.email(),
                        loginRequestDto.password()));
        return tokenProvider.generateToken(authentication);
    }

    public void signup(final SignupUserDto signupUserDto) {
        userService.createUser(signupUserDto.toEntity());
    }

    public TokenDto reissueToken(TokenDto tokenDto) {
        Authentication authentication = refreshTokenAuthProvider.authenticate(
                new BearerTokenAuthenticationToken(tokenDto.getRefreshToken()));

        Jwt jwt = (Jwt) authentication.getCredentials();
        // check if present in db and not revoked, etc
        return tokenProvider.generateToken(authentication);
    }

}
