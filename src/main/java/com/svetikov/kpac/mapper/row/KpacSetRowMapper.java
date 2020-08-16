package com.svetikov.kpac.mapper.row;

import com.svetikov.kpac.model.KpacSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KpacSetRowMapper implements RowMapper<KpacSet> {

    @Override
    public KpacSet mapRow(ResultSet rs, int i) throws SQLException {
        return KpacSet
                .builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .build();
    }
}
