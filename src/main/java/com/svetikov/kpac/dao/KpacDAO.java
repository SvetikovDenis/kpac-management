package com.svetikov.kpac.dao;

import com.svetikov.kpac.model.Kpac;

import javax.sql.DataSource;
import java.util.List;

public interface KpacDAO {

    List<Kpac> getAllKpacs();

    void setDataSource(DataSource dataSource);

    List<Kpac> getAllBySetId(Integer id);

    void create(Kpac kpac);

    void delete(Integer id);

    Kpac getById(Integer id);


}
