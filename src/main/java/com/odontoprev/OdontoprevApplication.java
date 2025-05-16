package com.odontoprev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.odontoprev.config")
public class OdontoprevApplication {
	public static void main(String[] args) {
		SpringApplication.run(OdontoprevApplication.class, args);
	}
}
