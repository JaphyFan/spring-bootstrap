package com.japhy.springsecurity.filter;

import com.japhy.springsecurity.VerificationException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author Japhy
 * @since 2021/1/27 16:50
 */
public class VerificationCodeFilter extends OncePerRequestFilter {

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {

        if (!request.getRequestURI().equals("/auth/form")) {
            filterChain.doFilter(request, response);
        } else {
            try {
                verifyCode(request, response);
            } catch (VerificationException e) {
                e.printStackTrace();
                throw new VerificationException();
            }
            filterChain.doFilter(request, response);
        }
    }

    public void verifyCode(HttpServletRequest request, HttpServletResponse response)
        throws VerificationException {
        String captcha = request.getParameter("captcha");
        HttpSession session = request.getSession();
        String savedCaptcha = (String) session.getAttribute("captcha");
        if (StringUtils.isNoneBlank(savedCaptcha)) {
            session.removeAttribute("captcha");
        }
        if (StringUtils.isBlank(savedCaptcha) || StringUtils.isBlank(captcha) || !savedCaptcha.equals(captcha)) {
            throw new VerificationException();
        }

    }
}
