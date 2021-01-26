package com.japhy.bootstrap.web.infrastructure.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

/**
 * WebFilter URL pattern 逻辑有点奇怪
 * @author Japhy
 * @since 2021/1/25 15:46
 */
@WebFilter("/api/v1/features/*")
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
