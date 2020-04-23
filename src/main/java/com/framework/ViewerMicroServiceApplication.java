package com.framework;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@ComponentScan("com.framework.business")
@ComponentScan("com.framework.controller")
public class ViewerMicroServiceApplication extends SpringBootServletInitializer implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ViewerMicroServiceApplication.class, args);
		ClassPathResource classPathResource = new ClassPathResource("log4j.properties");
		try {
			InputStream inputStrem = classPathResource.getInputStream();
			PropertyConfigurator.configure(inputStrem);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}

	
	@Bean
	 public FilterRegistrationBean filterRegistrationBean() {
	  FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	  StrutsPrepareAndExecuteFilter struts = new StrutsPrepareAndExecuteFilter();
	  registrationBean.setFilter(struts);
	  registrationBean.setOrder(1);
	  return registrationBean;
	 }
	 
	 
	 
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ViewerMicroServiceApplication.class);
	 }

	 @Override
	 public void run(ApplicationArguments args) throws Exception {
	  // TODO Auto-generated method stub

	 }	
	
}
