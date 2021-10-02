package org.example.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import java.util.concurrent.CountDownLatch;


@Slf4j
// @EnableAutoConfiguration
// @EnableConfigurationProperties
// @ComponentScan("org.example.validation")
// @EntityScan("org.example.validation")
// @ConfigurationPropertiesScan("org.example.validation")
// @Configuration
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
        // new CountDownLatch(1).await();
    }
    //
    // @EventListener(ContextStartedEvent.class)
    // public void started(ContextStartedEvent startedEvent) {
    //     log.debug("hey");
    // }
    //
    // @Bean
    // public Validator validator() {
    //     return new LocalValidatorFactoryBean();
    // }
}
