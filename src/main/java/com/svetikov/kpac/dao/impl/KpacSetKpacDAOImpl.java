package com.svetikov.kpac.dao.impl;

import com.svetikov.kpac.dao.KpacSetKpacDAO;
import com.svetikov.kpac.mapper.row.KpacSetKpacRowMapper;
import com.svetikov.kpac.model.KpacSetKpac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class KpacSetKpacDAOImpl implements KpacSetKpacDAO {


    final static String SET_KPAC_TABLE = "kpac_set_kpac";
    final static String KPAC_SET = "kpac_set_id";
    final static String KPAC = "kpac_id";

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(SET_KPAC_TABLE);
    }

    @Override
    public List<KpacSetKpac> getAll() {
        String query = String.format("select * from %s", SET_KPAC_TABLE);
        List<KpacSetKpac> kpacs = jdbcTemplate.query(query, new KpacSetKpacRowMapper());
        return kpacs;
    }

    @Override
    public List<KpacSetKpac> getBySetId(Integer id) {
        String query = String.format("select * from %s where %s = ?", SET_KPAC_TABLE, KPAC_SET);
        List<KpacSetKpac> kpacs = jdbcTemplate.query(query, new Object[]{id}, new KpacSetKpacRowMapper());
        return kpacs;
    }

    @Override
    public void save(KpacSetKpac kpacSetKpac) {
        final Map<String, Object> parameters = new HashMap();
        parameters.put(KPAC_SET, kpacSetKpac.getKpacSetId());
        parameters.put(KPAC, kpacSetKpac.getKpacId());
        simpleJdbcInsert.execute(parameters);
    }

    @Override
    public void delete(Integer id) {
        String query = String.format("delete from %s where id = ?", SET_KPAC_TABLE);
        jdbcTemplate.update(query, new Object[]{id});
    }

    @Override
    public void delete(KpacSetKpac kpacSetKpac) {
        String query = String.format("delete from %s where %s = ? and %s = ?", SET_KPAC_TABLE,KPAC_SET,KPAC);
        Integer setId = kpacSetKpac.getKpacSetId();
        Integer kpacId = kpacSetKpac.getKpacId();
        jdbcTemplate.update(query, new Object[]{setId,kpacId});
    }
}
