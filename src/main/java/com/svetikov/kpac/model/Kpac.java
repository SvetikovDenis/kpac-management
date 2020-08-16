package com.svetikov.kpac.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
public class Kpac extends AbstractEntity {

    @NotBlank(message = "Title can't be null or blank")
    private String title;

    @NotBlank(message = "Description can't be null or blank")
    private String description;

    public Kpac() {
    }

    @Builder
    public Kpac(Integer id, String title, String description, Date created) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
    }
}
