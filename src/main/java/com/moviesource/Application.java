package com.moviesource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//  @Bean
//  ApplicationRunner init(MovieRepository repository) {
//
////    String[][] data = {
////        {"sea", "Andrew", "300.12", "NDK"},
////        {"creek", "Andrew", "100.75", "Piranha"},
////        {"loaner", "Andrew", "75", "Necky"}
////    };
////
////    return args -> {
////      Stream.of(data).forEach(array -> {
////        try {
////          Kayak kayak = new Kayak(
////              array[0],
////              array[1],
////                  NumberFormat.getInstance().parse(array[2]),
////              array[3]
////          );
////          repository.save(kayak);
////        }
////        catch (ParseException e) {
////          e.printStackTrace();
////        }
////      });
////      repository.findAll().forEach(System.out::println);
////    };
////  }
//  }
}