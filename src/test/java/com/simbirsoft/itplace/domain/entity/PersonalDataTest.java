package com.simbirsoft.itplace.domain.entity;

import com.simbirsoft.itplace.dao.repository.PersonRepository;
import com.simbirsoft.itplace.dao.repository.impl.PersonRepositoryFromPropertyFileImpl;
import org.junit.Test;

import static org.junit.Assert.*;


public class PersonalDataTest {

    @Test
    public void getFIO() {
      /*  PersonRepository repository = new PersonRepositoryFromPropertyFileImpl(getClass().getClassLoader().getResourceAsStream("person.properties"));
        PersonalData data=repository.getPersonalData();
        assertEquals("Кожемяко Андрей Эдуардович", data.getFIO());*/
    }
}