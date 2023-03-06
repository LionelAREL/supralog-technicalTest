package com.supralog.supralogproject.config;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.UnsupportedEncodingException;

public class TimeProcessLogger implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory
      .getLogger(TimeProcessLogger.class);
  
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      String requestId = UUID.randomUUID().toString();
      log(request,response, requestId);
      long startTime = System.currentTimeMillis();
      request.setAttribute("startTime", startTime);
      request.setAttribute("requestId", requestId);
        return true;
    }
  
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
      long startTime = (Long)request.getAttribute("startTime");    
      long endTime = System.currentTimeMillis();
      long executeTime = endTime - startTime;
      ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
      String responseBody = getStringValue(responseWrapper.getContentAsByteArray(),response.getCharacterEncoding());
      logger.info("OUTPUT -- requestId: {}, Handle: {} , processing time: {}ms",request.getAttribute("requestId"), handler, executeTime,responseBody);
    }
  
    private void log(HttpServletRequest request, HttpServletResponse response, String requestId) {
      ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
      String requestBody = getStringValue(requestWrapper.getContentAsByteArray(),request.getCharacterEncoding());
      logger.info("INPUT -- requestId: {}, HttpMethod: {}",requestId,request.getMethod(),requestBody);
    }
    
    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
      try {
        return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
      return "";
    }
  }
