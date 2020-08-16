package com.svetikov.kpac.mapper.row;

import com.svetikov.kpac.model.Kpac;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class KpacRowMapper implements RowMapper<Kpac> {

    @Override
    public Kpac mapRow(ResultSet rs, int i) throws SQLException {

        return  Kpac
                .builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .created(rs.getDate("created"))
                .build();
    }
}
