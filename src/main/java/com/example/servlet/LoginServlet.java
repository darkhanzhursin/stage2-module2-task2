package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.Users;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();

    if (session.getAttribute("user") != null) {
      resp.sendRedirect("/user/hello.jsp");
    } else {
      resp.sendRedirect("/login.jsp");
    }
  }

  @Override
  protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    String user = req.getParameter("login");
    String password = req.getParameter("password");
    HttpSession session = req.getSession();

    if (Users.getInstance().getUsers().contains(user) && !password.isEmpty()) {
      session.setAttribute("user", user);
      resp.sendRedirect("/user/hello.jsp");
    } else {
      getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }
  }
}
