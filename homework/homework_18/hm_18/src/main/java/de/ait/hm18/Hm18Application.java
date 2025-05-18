package de.ait.hm18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Hm18Application {

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(Hm18Application.class, args);
        System.out.println("qwert");
    }

}
