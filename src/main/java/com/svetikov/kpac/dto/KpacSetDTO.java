package com.svetikov.kpac.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class KpacSetDTO extends AbstractDTO {

    @NotBlank(message = "Title can't be null or blank")
    private String title;

    private Integer kpacId;

    public KpacSetDTO() {
    }

    @Builder
    public KpacSetDTO(Integer id, String title, Integer kpacId) {
        this.id = id;
        this.title = title;
        this.kpacId = kpacId;
    }
}
