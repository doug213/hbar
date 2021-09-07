package com.henta.hedera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author henta
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public Application() {
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
