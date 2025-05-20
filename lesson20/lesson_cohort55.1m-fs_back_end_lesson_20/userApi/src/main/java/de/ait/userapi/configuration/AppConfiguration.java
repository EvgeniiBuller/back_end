package de.ait.userapi.configuration;

import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.logging.log4j.Logger;

@Configuration
public class AppConfiguration {

    @Bean
    public Logger getLogger(){

        Logger logger = LogManager.getLogger();

        return logger;
    }

}
