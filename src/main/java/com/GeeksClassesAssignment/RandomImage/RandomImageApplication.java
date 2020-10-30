package com.GeeksClassesAssignment.RandomImage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
////@ComponentScans({@ComponentScan("com.GeeksClassesAssignment.RandomImage.DbInterface"),
////		@ComponentScan("com.GeeksClassesAssignment.RandomImage.Resources")
//})
public class RandomImageApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomImageApplication.class, args);
	}


}
