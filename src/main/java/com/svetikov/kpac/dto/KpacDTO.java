package com.svetikov.kpac.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class KpacDTO extends AbstractDTO {

    @NotBlank(message = "Title can't be null or blank")
    private String title;

    @NotBlank(message = "Description can't be null or blank")
    private String description;

    private String created;

    public KpacDTO() {
    }

    @Builder
    public KpacDTO(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
