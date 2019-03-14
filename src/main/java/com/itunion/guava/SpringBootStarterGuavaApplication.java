package com.itunion.guava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//@SpringBootApplication
@ServletComponentScan
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})

public class SpringBootStarterGuavaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterGuavaApplication.class, args);
	}
}
