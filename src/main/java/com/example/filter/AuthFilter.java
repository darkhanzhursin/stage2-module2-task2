package com.example.filter;

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
import javax.servlet.http.HttpSession;

@WebFilter("/user/*")
public class AuthFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletResponse res = (HttpServletResponse) servletResponse;
    HttpServletRequest req = (HttpServletRequest) servletRequest;

    HttpSession session = req.getSession(false);
    if (session == null) {
      res.sendRedirect("/login.jsp");
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

}