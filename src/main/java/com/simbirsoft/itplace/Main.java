package com.simbirsoft.itplace;

import com.simbirsoft.itplace.service.api.SummaryService;
import com.simbirsoft.itplace.service.impl.SummaryServiceImpl;

import java.io.IOException;


//import org.apache.log4j.Logger;

public class Main {
    //private static final Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) throws IOException {
        SummaryService summaryService = new SummaryServiceImpl("person.properties");
        summaryService.createHtmlFile("src/main/webapp/summary.html");
        //log.info("Программа скомпелирована!!!");
    }
}
