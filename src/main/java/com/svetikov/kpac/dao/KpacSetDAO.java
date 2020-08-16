package com.svetikov.kpac.dao;

import com.svetikov.kpac.dto.KpacSetDTO;
import com.svetikov.kpac.model.Kpac;
import com.svetikov.kpac.model.KpacSet;

import javax.sql.DataSource;
import java.util.List;

public interface KpacSetDAO {

    void setDataSource(DataSource dataSource);

    List<KpacSet> getAll();

    KpacSet getById(Integer id);

    Integer save(KpacSet kpacSet);

    void deleteById(Integer id);
}
