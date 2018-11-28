package com.simbirsoft.itplace;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;


//import org.apache.log4j.Logger;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class, args);

    }
}

