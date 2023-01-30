package com.japhy.bootstrap.web.infrastructure.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

/**
 * @author Japhy
 * @since 2021/1/25 15:46
 */
@WebFilter("/*")
@Order(1)
@Slf4j
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info("starting transaction for req {}", req.getRequestURI());
        chain.doFilter(request, response);
        log.info("committing a transaction for req: {}", req.getRequestURI());
    }

    @Override
    public void destroy() {

    }
}
