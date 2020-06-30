package com.zsmart.gestionDesSoutenances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GestionDesSoutenancesApplication {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
					.addMapping("*")
					.allowedHeaders("*")
					.allowedOrigins("*")
					.allowCredentials(true);
			}
			
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(GestionDesSoutenancesApplication.class, args);
	}

   
}
