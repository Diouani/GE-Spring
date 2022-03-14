package com.jwt.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@WebFilter(urlPatterns = { "/admin/*" })
public class Filter implements javax.servlet.Filter {
    public  void init(FilterConfig filterConfig) {


    }

    public  void destroy() {

    }


    public  void doFilter(ServletRequest request, ServletResponse response,
                          FilterChain filterChain)
            throws IOException, ServletException {



        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("UserId") != null);




        if (isLoggedIn && session.getAttribute("role").equals("Admin")) {


            filterChain.doFilter(request, response) ;

        }else {

            httpResponse.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("You can't access to this route");


        }


    }
}