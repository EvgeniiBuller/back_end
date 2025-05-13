package de.ait.hm_13;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Hm13Application {

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(Hm13Application.class, args);
        System.out.println("qwert");
    }

}
