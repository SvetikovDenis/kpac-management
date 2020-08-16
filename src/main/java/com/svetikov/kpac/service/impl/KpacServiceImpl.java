package com.svetikov.kpac.service.impl;

import com.svetikov.kpac.dao.KpacDAO;
import com.svetikov.kpac.dto.KpacDTO;
import com.svetikov.kpac.exception.EntityNotFoundException;
import com.svetikov.kpac.mapper.dto.KpacDTOMapper;
import com.svetikov.kpac.model.Kpac;
import com.svetikov.kpac.service.KpacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KpacServiceImpl implements KpacService {

    @Autowired
    private KpacDAO kpacDAO;

    @Autowired
    private KpacDTOMapper kpacDTOMapper;

    private final Logger log = LoggerFactory.getLogger(KpacServiceImpl.class);

    @Override
    public List<Kpac> getAll() {
        List<Kpac> kpacs = kpacDAO.getAllKpacs();
        if (kpacs.isEmpty()) {
            log.info("In getAll - no kpacs was found");
            return kpacs;
        }
        log.info("In getAll - {} kpacs was found",kpacs.size());
        return kpacs;
    }

    @Override
    public List<KpacDTO> getAllDTO() {
        List<Kpac> kpacs = kpacDAO.getAllKpacs();
        if (kpacs.isEmpty()) {
            log.info("In getAllDTO - no kpacs was found");
            return new ArrayList();
        }
        log.info("In getAllDTO - {} kpacs was found",kpacs.size());
        return kpacs
                .stream()
                .map(kpacDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Kpac> getAllBySetId(Integer id) {
        List<Kpac> kpacs = kpacDAO.getAllBySetId(id);
        if (kpacs.isEmpty()) {
            log.info("In getAllBySetId - no kpacs was found for set with id : {}",id);
            return new ArrayList<>();
        }
        log.info("In getAllBySetId - {} kpacs was found for set with id : {} ",kpacs.size(),id);
        return kpacs;
    }

    @Override
    public Kpac getById(Integer id) {
        Kpac kpac = kpacDAO.getById(id);
        if (kpac == null) {
            log.warn("In getById - kpac with id : {} was not found", id);
            throw new EntityNotFoundException(Kpac.class, "id", id.toString());
        }
        log.info("In getById - kpac with id : {} was found", id);
        return kpac;
    }

    @Override
    public void save(Kpac kpac) {
        kpacDAO.create(kpac);
        log.info("In save - kpac: {} was saved",kpac);
    }

    @Override
    public void deleteById(Integer id) {
        kpacDAO.delete(id);
        log.info("In deleteById - kpac with id: {} was deleted",id);
    }

}
