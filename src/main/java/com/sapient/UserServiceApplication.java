package com.sapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages= {"com.sapient.user"})
public class UserServiceApplication extends SpringBootServletInitializer  {
	public static void main(String[] args) {		
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(UserServiceApplication.class);
//    }
}
