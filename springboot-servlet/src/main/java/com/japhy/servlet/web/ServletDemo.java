package com.japhy.servlet.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        resp.getWriter().println("custom sevlet");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
