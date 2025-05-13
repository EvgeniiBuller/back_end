package de.ait.hm_13.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class AppConfiguration {

    @Bean
    public Scanner getMyscanner(){
        System.out.println("Enter a string");
        return new Scanner(System.in);
    }
}
