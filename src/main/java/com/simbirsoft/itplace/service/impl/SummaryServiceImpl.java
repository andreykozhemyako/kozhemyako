package com.simbirsoft.itplace.service.impl;

import com.simbirsoft.itplace.Main;
import com.simbirsoft.itplace.dao.repository.PersonRepository;
import com.simbirsoft.itplace.dao.repository.impl.PersonRepositoryFromPropertyFileImpl;
import com.simbirsoft.itplace.domain.entity.PersonalData;
import com.simbirsoft.itplace.service.api.SummaryService;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    private PersonalData personalData;
    //private static final Logger log = Logger.getLogger(SummaryServiceImpl.class);

    public SummaryServiceImpl(String propertyFilePath) throws IOException {
        /*PersonRepository personRepository = new PersonRepositoryFromPropertyFileImpl(
                getClass().getClassLoader().getResourceAsStream(propertyFilePath)
        );
        this.personalData = personRepository.getPersonalData();
        this.personalData.readPropertyFile();*/
    }


    private StringBuilder makeHtmlListFromMap(Map <String, Integer> map){

        StringBuilder str = new StringBuilder("<ol>\n");


        for(Map.Entry m : map.entrySet()){
            str.append("<li>" + m.getKey() + ":" + m.getValue() + "</li>\n");
        }

        str.append("</ol>\n");

        return str;
    }

    @Override
    public void createHtmlFile(String pathHtmlFile) {
        if (this.personalData != null){
            String html = "<!DOCTYPE html>\n" +
                    "<html lang=\"ru\">\n" +
                    "<meta charset=\"utf-8\">"+
                    "<head>\n" +
                    "    <title>Резюме</title>\n" +
                    "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
                    "          integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\n" +
                    "          crossorigin=\"anonymous\">\n" +
                    "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"\n" +
                    "            integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\"\n" +
                    "            crossorigin=\"anonymous\">" +
                    "   </script>\n" +
                    "    <style>\n" +
                    "        body{background: darkgray; padding: 10px 0;}\n" +
                    "        .container { max-width: 50%; background: white; padding: 10px;}\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <h3 class=\"text-center\"><strong>Резюме</strong><p>на должность Java-стажер</p></h3>\n" +
                    "        <div class=\"row\">\n" +
                    "            <div class=\"col-xs-8 col-md-8\">\n" +
                    "                <dl class=\"dl-horizontal\">\n" +
                    "                    <dt>ФИО:</dt><dd>" + personalData.getFIO() + "</dd>\n" +
                    "                    <dt>Дата рождения:</dt><dd>" + personalData.getDOB() + "</dd>\n" +
                    "                    <dt>Телефон:</dt><dd>" + personalData.getPhone() + "</dd>\n" +
                    "                    <dt>e-mail:</dt><dd>" + personalData.getEmail() + "</dd>\n" +
                    "                    <dt>Skype:</dt><dd>" + personalData.getSkype() + "</dd>\n" +
                    "                </dl></div>\n" +
                    "            <div class=\"col-xs-4 col-md-4\">\n" +
                    "                <img src=\"" + personalData.getAvatar() + "\" width=\"100%\">\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h3 class=\"card-title\"><strong>Цель:</strong></h3>\n" +
                    "            <p class=\"card-text\">" + personalData.getTarget() + "</p>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h3 class=\"card-title\"><strong>Опыт работы:</strong></h3>\n" +
                    "            <ol class=\"card-text\">\n"
                                    + personalData.getExperiences() +
                    "            </ol>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h3 class=\"card-title\"><strong>Образование:</strong></h3>\n" +
                    "            <p class=\"card-text\">" + personalData.getEducations() + "</p>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h3 class=\"card-title\"><strong>Доп. образ. и курсы:</strong></h3>\n" +
                    "            <ol class=\"card-text\">\n"
                                    + personalData.getAdditionalEducations() +
                    "            </ol>\n" +
                    "        </div>\n" +
                    "        <div class=\"card card-block\">\n" +
                    "            <h3 class=\"card-title\"><strong>Навыки:</strong></h3>\n" +
                    "            <ol class=\"card-text\">\n"
                                    + makeHtmlListFromMap(personalData.skillsMap) +
                    "            </ol>\n" +
                    "        </div>\n" +
                    "   </div>\n" +
                    "</body>\n" +
                    "</html>";

            try(FileWriter writer = new FileWriter(pathHtmlFile, false)) {
                File file = new File(pathHtmlFile);
                if(!file.exists()) {
                    file.createNewFile();
                }
                writer.write(html);
                writer.flush();
            }
            catch(IOException ex){
               // log.info(ex.getLocalizedMessage());
            }
        }
    }
}
