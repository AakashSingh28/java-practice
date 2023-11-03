package com.java.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		if( "45.1250 52.2500 60.5000".equals(Algorithm.getSharePrices(50,1.1,0.95,2)))
			System.out.println("Success!");
		else
			System.out.println("FAIL!");

	}

}
