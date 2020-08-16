package com.svetikov.kpac.dao;

import com.svetikov.kpac.model.KpacSetKpac;

import javax.sql.DataSource;
import java.util.List;

public interface KpacSetKpacDAO {

    void setDataSource(DataSource dataSource);

    List<KpacSetKpac> getAll();

    List<KpacSetKpac> getBySetId(Integer id);

    void save(KpacSetKpac kpacSetKpac);

    void delete(Integer id);

    void delete(KpacSetKpac kpacSetKpac);


}
