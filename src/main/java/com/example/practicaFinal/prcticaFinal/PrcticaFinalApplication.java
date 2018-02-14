package com.example.practicaFinal.prcticaFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement

public class PrcticaFinalApplication {


	public static void main(String[] args) {
		SpringApplication.run(PrcticaFinalApplication.class, args);
	}
}
