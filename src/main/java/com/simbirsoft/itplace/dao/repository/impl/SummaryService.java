package com.simbirsoft.itplace.dao.repository.impl;

import com.simbirsoft.itplace.domain.entity.PersonalData;

import java.io.InputStream;

public interface SummaryService {
    void openProperty(InputStream InStream);
    PersonalData getDataFromProperty();
}
