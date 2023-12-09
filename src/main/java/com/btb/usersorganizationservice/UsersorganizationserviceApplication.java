package com.btb.usersorganizationservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.btb.usersorganizationservice.persistence.mapper"})
@SpringBootApplication
public class UsersorganizationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersorganizationserviceApplication.class,args);
	}

}
