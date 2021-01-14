package com.japhy.servlet.web;

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
