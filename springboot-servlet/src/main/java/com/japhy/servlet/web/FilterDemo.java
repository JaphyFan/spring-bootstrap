package com.japhy.servlet.web;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Japhy
 * @description
 * @date 2019-07-24 01:08
 */
@WebFilter(urlPatterns = "/test" )
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String age = request.getParameter("age");
        if (Long.valueOf(age).compareTo(10L) > 0) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("index.html");
        }
    }

    @Override
    public void destroy() {
        System.out.println("filter is destroyed");
    }
}
