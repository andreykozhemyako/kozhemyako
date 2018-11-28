package com.simbirsoft.itplace.service.impl;



import com.simbirsoft.itplace.dao.repository.PersonRepository;
import com.simbirsoft.itplace.domain.entity.PersonalData;
import com.simbirsoft.itplace.service.api.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertyService implements ServiceInterface {

    @Autowired
    private PersonRepository persFromProp;


    public PersonalData getData(String pass){

        persFromProp.openProperty(getClass().getClassLoader().getResourceAsStream(pass));
        return persFromProp.getPersonalData();
    }
}

