package com.japhy.servlet.web.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

/**
 * @author Japhy
 * @since 2021/1/25 15:46
 */
//@Component
@Order(2)
@Slf4j
public class RequestResponseLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        log.info(
            "Logging Request  {} : {}", req.getMethod(),
            req.getRequestURI());
        chain.doFilter(request, response);
        log.info(
            "Logging Response :{}",
            res.getContentType());
    }

    @Override
    public void destroy() {

    }
}
