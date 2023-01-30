package com.japhy.servlet.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Japhy
 * @description
 * @date 2019-07-24 01:44
 */
@WebServlet(name = "customServlet", urlPatterns = "/v1/custom_servlet")
public class ServletDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("custom servlet");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
