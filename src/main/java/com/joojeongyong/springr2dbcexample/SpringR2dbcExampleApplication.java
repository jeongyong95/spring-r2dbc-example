package com.joojeongyong.springr2dbcexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@EnableR2dbcAuditing
@SpringBootApplication
public class SpringR2dbcExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringR2dbcExampleApplication.class, args);
    }

}
