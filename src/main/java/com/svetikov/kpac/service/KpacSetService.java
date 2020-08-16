package com.svetikov.kpac.service;

import com.svetikov.kpac.dto.KpacSetDTO;
import com.svetikov.kpac.model.Kpac;
import com.svetikov.kpac.model.KpacSet;

import java.util.List;

public interface KpacSetService {

    List<KpacSet> getAll();

    KpacSet getById(Integer id);

    KpacSetDTO getByIdDTO(Integer id);

    void save(KpacSetDTO kpacSet);

    void save(KpacSet kpacSet);

    void deleteById(Integer id);

}
