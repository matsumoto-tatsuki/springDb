package com.example.lesson;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LessonApplication {

	public static void main(String[] args) {

		SpringApplication.run(LessonApplication.class, args);
//
//		ConfigurableApplicationContext context =
//				SpringApplication.run(LessonApplication.class, args);
//		ProductService productService = context.getBean(ProductService.class);

//		var list = productService.findAll();
//		list.stream().forEach(System.out::println);
//
//		System.out.println(productService.findById(101));

//		var num = productService.insert(new ProductRecord(104,"机",2000));
//		System.out.println("INSERT : " + num + "件");

//		var num1 = productService.update(new ProductRecord(104,"机",5000));
//		System.out.println("UPDATE : " + num1 + "件");

//		var num2 = productService.delete(104);
//		System.out.println("UPDATE : " + num2 + "件");
	}

}
