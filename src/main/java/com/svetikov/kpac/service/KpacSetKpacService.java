package com.svetikov.kpac.service;

import com.svetikov.kpac.dto.KpacSetKpacDTO;
import com.svetikov.kpac.model.KpacSetKpac;
import org.springframework.stereotype.Service;

import java.util.List;

public interface KpacSetKpacService {

    List<KpacSetKpac> getAll();

    List<KpacSetKpac> getAllBySetId(Integer id);

    void save(KpacSetKpac kpacSetKpac);

    void save(KpacSetKpacDTO kpacSetKpac);

    void delete(Integer setId, Integer kpacId);

    void delete(KpacSetKpac kpacSetKpac);

    void delete(Integer id);



}
