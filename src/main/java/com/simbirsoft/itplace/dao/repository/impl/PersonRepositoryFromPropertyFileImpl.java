package com.simbirsoft.itplace.dao.repository.impl;

import com.simbirsoft.itplace.common.constants.PersonPropertyKeys;
import com.simbirsoft.itplace.dao.repository.PersonRepository;
import com.simbirsoft.itplace.domain.entity.PersonalData;
import com.simbirsoft.itplace.service.impl.SummaryServiceImpl;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

@Component
public class PersonRepositoryFromPropertyFileImpl implements PersonRepository {
    //Свойство - опыт работы
    private Properties personDataFile;
   // private static final Logger log = Logger.getLogger(SummaryServiceImpl.class);
    @Override
    public void openProperty(InputStream InStream){
        this.personDataFile = getProperties(InStream);
    }

   /* public PersonRepositoryFromPropertyFileImpl(InputStream configFileInput){
        this.personDataFile = getProperties(configFileInput);
    }*/

    private Properties getProperties(InputStream configFileInput) {
        Properties property = new Properties();
        try (InputStreamReader inputStreamReader = new InputStreamReader(configFileInput, Charset.forName("UTF-8"))){
            property.load(inputStreamReader);
            return property;
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл настроек");
            e.printStackTrace();
            //log.info(e.getLocalizedMessage());
        } catch (IOException e) {
            e.printStackTrace();
           // log.info(e.getLocalizedMessage());
        }
        return null;

    }



    @Override
    public PersonalData getPersonalData() {
        PersonalData personalData = null;
        if(this.personDataFile != null){
            personalData = new PersonalData(
                    personDataFile.getProperty(PersonPropertyKeys.FIO),
                    personDataFile.getProperty(PersonPropertyKeys.DOB),
                    personDataFile.getProperty(PersonPropertyKeys.PHONE),
                    personDataFile.getProperty(PersonPropertyKeys.EMAIL),
                    personDataFile.getProperty(PersonPropertyKeys.SKYPE),
                    personDataFile.getProperty(PersonPropertyKeys.AVATAR),
                    personDataFile.getProperty(PersonPropertyKeys.TARGET),
                    personDataFile.getProperty(PersonPropertyKeys.EXPERIENCES),
                    personDataFile.getProperty(PersonPropertyKeys.EDUCATIONS),
                    personDataFile.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS),
                    personDataFile.getProperty(PersonPropertyKeys.SKILLS)
            );
        }
        return personalData;

    }
}
