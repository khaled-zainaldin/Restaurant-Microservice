package com.server_regiter.server_regiter;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerRegiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerRegiterApplication.class, args);
	}

}
