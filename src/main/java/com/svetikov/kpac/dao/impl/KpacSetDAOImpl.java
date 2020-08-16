package com.svetikov.kpac.dao.impl;

import com.svetikov.kpac.dao.KpacSetDAO;
import com.svetikov.kpac.mapper.row.KpacSetRowMapper;
import com.svetikov.kpac.model.KpacSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class KpacSetDAOImpl implements KpacSetDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("kpac_set").usingGeneratedKeyColumns("id");
    }

    @Override
    public List<KpacSet> getAll() {
        String query = "select * from kpac_set";
        List<KpacSet> kpacs = jdbcTemplate.query(query, new KpacSetRowMapper());
        return kpacs;
    }


    @Override
    public KpacSet getById(Integer id) {
        String query = "select * from kpac_set where id = ?";
        return jdbcTemplate.queryForObject(query,new Object[]{id},new KpacSetRowMapper());
    }


    @Override
    public Integer save(KpacSet kpacSet) {
        final Map<String, Object> parameters = new HashMap();
        parameters.put("title", kpacSet.getTitle());
        parameters.put("created", new Date(System.currentTimeMillis()));
        Integer id = simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
        return id;
    }

    @Override
    public void deleteById(Integer id) {
        String query = "delete from kpac_set where id = ?";
        jdbcTemplate.update(query, new Object[]{id});
    }
}
