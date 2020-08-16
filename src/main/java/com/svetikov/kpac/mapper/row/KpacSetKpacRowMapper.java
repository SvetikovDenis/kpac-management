package com.svetikov.kpac.mapper.row;

import com.svetikov.kpac.model.KpacSetKpac;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KpacSetKpacRowMapper implements RowMapper<KpacSetKpac> {

    @Override
    public KpacSetKpac mapRow(ResultSet rs, int i) throws SQLException {
        return KpacSetKpac
                .builder()
                .id(rs.getInt("id"))
                .kpacSetId(rs.getInt("kpac_set_id"))
                .kpacId(rs.getInt("kpac_id"))
                .build();
    }
}
