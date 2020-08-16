package com.svetikov.kpac.dao.impl;

import com.svetikov.kpac.dao.KpacDAO;
import com.svetikov.kpac.mapper.row.KpacRowMapper;
import com.svetikov.kpac.model.Kpac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class KpacDAOImpl implements KpacDAO {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    @Override
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("kpac");
    }

    @Override
    public void create(Kpac kpac) {
        final Map<String, Object> parameters = new HashMap();
        parameters.put("title", kpac.getTitle());
        parameters.put("description", kpac.getDescription());
        parameters.put("created", new Date(System.currentTimeMillis()));
        simpleJdbcInsert.execute(parameters);
    }

    @Override
    public Kpac getById(Integer id) {
        String query = "Select * from kpac where id = ?";
        return jdbcTemplate.queryForObject(query,new Object[]{id},new KpacRowMapper());
    }

    @Override
    public List<Kpac> getAllKpacs() {
        String query = "select * from kpac";
        List<Kpac> kpacs = jdbcTemplate.query(query, new KpacRowMapper());
        return kpacs;
    }


    @Override
    public List<Kpac> getAllBySetId(Integer id) {
        String query = "select " +
                "k.id," +
                "k.title," +
                "k.description,      " +
                "k.created " +
                "from kpac_set_kpac ks " +
                "inner join kpac k on ks.kpac_id = k.id " +
                "where kpac_set_id = ?";

        return jdbcTemplate.query(query,new Object[]{id},new KpacRowMapper());
    }

    @Override
    public void delete(Integer id) {
        String query = "delete from kpac where id = ?";
        jdbcTemplate.update(query, new Object[]{id});
    }
}
