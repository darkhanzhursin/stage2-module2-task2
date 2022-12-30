package com.example.listener;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
  @Override
  public void contextInitialized(final ServletContextEvent sce) {
    ServletContext ctx = sce.getServletContext();
    LocalDateTime localDateTime = LocalDateTime.now();

    ctx.setAttribute("servletTimeInit", localDateTime);
  }

  @Override public void contextDestroyed(final ServletContextEvent sce) {
    ServletContextListener.super.contextDestroyed(sce);
  }
  //write your code here!

}
