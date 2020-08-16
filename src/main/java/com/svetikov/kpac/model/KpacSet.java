package com.svetikov.kpac.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
public class KpacSet extends AbstractEntity{

    @NotBlank(message = "Title should't be null or blank")
    private String title;

    public KpacSet() {
    }

    @Builder
    public KpacSet(Integer id, String title, Date created) {
        this.id = id;
        this.title = title;
        this.created = created;
    }
}
