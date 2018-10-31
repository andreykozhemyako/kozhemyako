package com.simbirsoft.itplace;

import com.simbirsoft.itplace.service.api.SummaryService;
import com.simbirsoft.itplace.service.impl.SummaryServiceImpl;

public class Main {

    public static void main(String[] args) {
        SummaryService summaryService = new SummaryServiceImpl("person.properties");
        summaryService.createHtmlFile("src/main/webapp/summary.html");
    }
}
