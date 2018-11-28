package com.simbirsoft.itplace.dao.repository.impl;

import java.io.*;
import java.util.Properties;

import com.simbirsoft.itplace.common.constants.PersonPropertyKeys;
import com.simbirsoft.itplace.domain.entity.PersonalData;
import org.springframework.stereotype.Component;


@Component
public class PersonRepositoryFromPropertyFileImpl implements SummaryService {
    private Properties prop;


    @Override
    public void openProperty(InputStream InStream){
        this.prop = getProperties(InStream);
    }

    private Properties getProperties(InputStream InStream){
        prop = new Properties();
        try {
            prop.load(new InputStreamReader(InStream));
            return prop;
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return null;

    }


    @Override
    public PersonalData getDataFromProperty(){
        PersonalData data = null;
        if(prop != null){
            data = new PersonalData(
                    prop.getProperty(PersonPropertyKeys.FIO),
                    prop.getProperty(PersonPropertyKeys.DOB),
                    prop.getProperty(PersonPropertyKeys.PHONE),
                    prop.getProperty(PersonPropertyKeys.EMAIL),
                    prop.getProperty(PersonPropertyKeys.SKYPE),
                    prop.getProperty(PersonPropertyKeys.AVATAR),
                    prop.getProperty(PersonPropertyKeys.TARGET),
                    prop.getProperty(PersonPropertyKeys.EXPERIENCES),
                    prop.getProperty(PersonPropertyKeys.EDUCATIONS),
                    prop.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS),
                    prop.getProperty(PersonPropertyKeys.SKILLS)
            );
        }
        return data;
    }
}

