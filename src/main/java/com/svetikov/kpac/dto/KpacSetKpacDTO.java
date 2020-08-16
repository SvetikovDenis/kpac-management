package com.svetikov.kpac.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class KpacSetKpacDTO extends AbstractDTO {

    @NotNull
    private Integer kpacId;

    @NotNull
    private Integer kpacSetId;

    public KpacSetKpacDTO() {
    }

    @Builder
    public KpacSetKpacDTO(Integer id, Integer kpacId, Integer kpacSetId) {
        this.id = id;
        this.kpacId = kpacId;
        this.kpacSetId = kpacSetId;
    }
}
