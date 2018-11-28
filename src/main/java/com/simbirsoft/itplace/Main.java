package com.simbirsoft.itplace;

import com.simbirsoft.itplace.service.api.SummaryService;
import com.simbirsoft.itplace.service.impl.SummaryServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;


//import org.apache.log4j.Logger;
@SpringBootApplication
public class Main {
    //private static final Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        /*SummaryService summaryService = new SummaryServiceImpl("person.properties");
        summaryService.createHtmlFile("src/main/webapp/summary.html");*/
        ApplicationContext context = SpringApplication.run(Main.class, args);

        SummaryService service = context.getBean(SummaryService.class);
        service.createHtmlFile("src/main/webapp/summary.html");

        //log.info("Программа скомпелирована!!!");
    }
}
