package com.svetikov.kpac.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class KpacSetKpac {

    private Integer id;

    @NotNull
    private Integer kpacId;

    @NotNull
    private Integer kpacSetId;

    public KpacSetKpac() {
    }

    @Builder
    public KpacSetKpac(Integer id, Integer kpacId, Integer kpacSetId) {
        this.id = id;
        this.kpacId = kpacId;
        this.kpacSetId = kpacSetId;
    }
}
