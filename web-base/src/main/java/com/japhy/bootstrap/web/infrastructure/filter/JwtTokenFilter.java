package com.japhy.bootstrap.web.infrastructure.filter;

import com.japhy.bootstrap.web.infrastructure.util.JwtUtil;
import com.japhy.bootstrap.web.infrastructure.util.WebUserDetailsService;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author Japhy
 * @since 2021/1/30 14:05
 */
@Component
@RequiredArgsConstructor
@Profile("!unit-test")
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    private final WebUserDetailsService webUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain chain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isBlank(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        String jwtToken = authorizationHeader.substring(7);

        UserDetails userDetails =
            webUserDetailsService.loadUserByUsername(jwtUtil.extractUsername(jwtToken));
        if (!jwtUtil.validateToken(jwtToken, userDetails)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(userDetails, null,
                Optional.ofNullable(userDetails).map(UserDetails::getAuthorities).orElse(
                    Collections.emptyList()));
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }
}
