package com.piseth.payment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentServiceApplication {

    static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            @Value("${service.info}") String info,
//            @Value("${secret.weak-password}") String weakPassword,
//            @Value("${secret.strong-password}") String strongPassword) {
//        return _ -> {
//            System.out.println("Hello from " + info);
//            System.out.println("Weak password: " + weakPassword);
//            System.out.println("Strong password: " + strongPassword);
//        };
//    }
}
