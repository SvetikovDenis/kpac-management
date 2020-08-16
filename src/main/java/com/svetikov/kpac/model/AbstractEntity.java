package com.svetikov.kpac.model;

import lombok.Data;

import java.sql.Date;

@Data
public class AbstractEntity {

    Integer id;

    Date created;

}
