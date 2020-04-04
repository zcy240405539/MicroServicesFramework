package com.framework.controller;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoggingIntercept extends AbstractInterceptor
{
    public String intercept(ActionInvocation ai)
    throws Exception
  {
    long startTime = System.currentTimeMillis();
    System.out.println("Entering intercepor call");
    String actionResult = ai.invoke();
    long stopTime = System.currentTimeMillis();
    System.out.println("Exiting intercepor call , time taken :" + (stopTime - startTime) + " ms");
    System.out.println(actionResult);
    return actionResult;
  }
}
