package com.example.Demo;

import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomRequestInterceptor implements HandlerInterceptor {

 @Override
 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

  long startTime = Instant.now().toEpochMilli();
  log.info("Request URL:: " + request.getMethod() + " " + request.getRequestURL().toString() +
   ":: Start Time=" + Instant.now());
  request.setAttribute("startTime", startTime);
  return true;
 }

 @Override
 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

  long startTime = (Long) request.getAttribute("startTime");

  log.info("Request URL:: " + request.getMethod()+ " " + request.getRequestURL().toString() +
   ":: Time Taken=" + (Instant.now().toEpochMilli() - startTime));
 }
}