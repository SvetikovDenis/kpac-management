package com.svetikov.kpac.mapper.dto;

import com.svetikov.kpac.dto.KpacSetDTO;
import com.svetikov.kpac.model.KpacSet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KpacSetDTOMapper {

    @Autowired
    private ModelMapper modelMapper;

    public KpacSet toEntity(KpacSetDTO kpacSetDTO) {
        KpacSet kpacSet = modelMapper.map(kpacSetDTO,KpacSet.class);
        return kpacSet;
    }

    public KpacSetDTO toDTO(KpacSet kpacSet) {
        KpacSetDTO kpacSetDTO = modelMapper.map(kpacSet, KpacSetDTO.class);
        return kpacSetDTO;
    }

}
