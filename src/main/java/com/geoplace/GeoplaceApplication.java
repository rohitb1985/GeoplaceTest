package com.geoplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * This is the starting class for the spring boot application.
 * To run the application we just need to run this class as a Java Application. 
 * Once application is started we can access the application on localhost port 8080.
 * Extending the SpringBootServletInitializer so that the application can be deployed as a war file also in any web application container like tomcat.
 * @author Rohit
 *
 */
@SpringBootApplication
public class GeoplaceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GeoplaceApplication.class, args);
	}

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(GeoplaceApplication.class);
	}
}
