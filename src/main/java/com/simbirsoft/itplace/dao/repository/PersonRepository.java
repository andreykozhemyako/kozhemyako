package com.simbirsoft.itplace.dao.repository;

import com.simbirsoft.itplace.domain.entity.PersonalData;

import java.io.InputStream;


public interface PersonRepository {

    void openProperty(InputStream InStream);
    PersonalData getPersonalData();
}
