package com.svetikov.kpac.mapper.dto;

import com.svetikov.kpac.dto.KpacSetKpacDTO;
import com.svetikov.kpac.model.KpacSetKpac;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KpacSetKpacDTOMapper {


    @Autowired
    private ModelMapper modelMapper;

    public KpacSetKpac toEntity(KpacSetKpacDTO kpacSetKpacDTO) {
        KpacSetKpac kpacSetKpac = modelMapper.map(kpacSetKpacDTO,KpacSetKpac.class);
        return kpacSetKpac;
    }

    public KpacSetKpacDTO toDTO(KpacSetKpac kpacSetKpac) {
        KpacSetKpacDTO kpacSetKpacDTO = modelMapper.map(kpacSetKpac,KpacSetKpacDTO.class);
        return kpacSetKpacDTO;
    }


}
