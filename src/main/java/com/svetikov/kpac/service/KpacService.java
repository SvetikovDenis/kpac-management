package com.svetikov.kpac.service;

import com.svetikov.kpac.dto.KpacDTO;
import com.svetikov.kpac.model.Kpac;

import java.util.List;

public interface KpacService {

    List<Kpac> getAll();

    List<KpacDTO> getAllDTO();

    List<Kpac> getAllBySetId(Integer id);

    Kpac getById(Integer id);

    void save(Kpac kpac);

    void deleteById(Integer id);

}
