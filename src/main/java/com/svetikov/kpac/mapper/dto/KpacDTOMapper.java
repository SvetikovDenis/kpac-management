package com.svetikov.kpac.mapper.dto;

import com.svetikov.kpac.dto.KpacDTO;
import com.svetikov.kpac.model.Kpac;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Component
public class KpacDTOMapper {

    private static final SimpleDateFormat toEUformatter = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    private ModelMapper mapper;

    @PostConstruct
    public void setupMapper() {

        mapper.createTypeMap(Kpac.class, KpacDTO.class)
                .addMappings(m -> m.skip(KpacDTO::setCreated)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(KpacDTO.class, Kpac.class)
                .addMappings(m -> m.skip(Kpac::setCreated)).setPostConverter(toEntityConverter());
    }

    Converter<Kpac, KpacDTO> toDtoConverter() {
        return context -> {
            Kpac source = context.getSource();
            KpacDTO destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    Converter<KpacDTO, Kpac> toEntityConverter() {
        return context -> {
            KpacDTO source = context.getSource();
            Kpac destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    void mapSpecificFields(Kpac source, KpacDTO destination) {
        destination.setCreated(Objects.isNull(source) || Objects.isNull(source.getCreated()) ? null : toEUformatter.format(source.getCreated()));
    }

    void mapSpecificFields(KpacDTO source, Kpac destination) {

    }

    public Kpac toEntity(KpacDTO kpacDTO) {
        Kpac kpac = mapper.map(kpacDTO, Kpac.class);
        return kpac;
    }

    public KpacDTO toDTO(Kpac kpac) {
        KpacDTO kpacDTO = mapper.map(kpac, KpacDTO.class);
        return kpacDTO;
    }


}
