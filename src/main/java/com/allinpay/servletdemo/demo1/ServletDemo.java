package com.allinpay.servletdemo.demo1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo
 */
public class ServletDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private @Resource(name = "i") int i;
    public ServletDemo() {
        super();
        System.out.println("Hello Servlet by liwei!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
        String destination = request.getParameter("destination");
        if ("file".equals(destination)) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/web.xml");
            rd.forward(request, response);
        }
        else if ("servlet".equals(destination)) {
            RequestDispatcher rd = request.getRequestDispatcher("/demo2");
            rd.forward(request, response);
        }
        else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("缺少参数，用法:"+request.getRequestURL()+"?destination=jsp或者file或者servlet");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String action = request.getParameter("action");
        if("login_input".equals(action)) {
            request.getRequestDispatcher("login.jsp").forward(request , response);
        } else if("login".equals(action)) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            System.out.println("name->" + name + ",password->" + password + ",i->"+i);
        }
    }

}