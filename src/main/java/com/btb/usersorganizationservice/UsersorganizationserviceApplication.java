package com.btb.usersorganizationservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.btb.usersorganizationservice.persistence.mapper"})
@SpringBootApplication
public class UsersorganizationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersorganizationserviceApplication.class,args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedOrigins("*")
						.allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
								"Access-Control-Request-Headers", "Authorization")
						.exposedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
								"Access-Control-Request-Headers", "Authorization");
			}

		};
	}

}
