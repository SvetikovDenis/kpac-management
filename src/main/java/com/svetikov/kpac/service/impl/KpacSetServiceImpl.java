package com.svetikov.kpac.service.impl;

import com.svetikov.kpac.dao.KpacSetDAO;
import com.svetikov.kpac.dto.KpacSetDTO;
import com.svetikov.kpac.exception.EntityNotFoundException;
import com.svetikov.kpac.mapper.dto.KpacSetDTOMapper;
import com.svetikov.kpac.model.Kpac;
import com.svetikov.kpac.model.KpacSet;
import com.svetikov.kpac.model.KpacSetKpac;
import com.svetikov.kpac.service.KpacService;
import com.svetikov.kpac.service.KpacSetKpacService;
import com.svetikov.kpac.service.KpacSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KpacSetServiceImpl implements KpacSetService {

    @Autowired
    private KpacSetDAO kpacSetDAO;

    @Autowired
    private KpacService kpacService;

    @Autowired
    private KpacSetKpacService kpacSetKpacService;

    @Autowired
    private KpacSetDTOMapper kpacSetDTOMapper;

    private final Logger log = LoggerFactory.getLogger(KpacSetServiceImpl.class);

    @Override
    public List<KpacSet> getAll() {
        List<KpacSet> kpacSets = kpacSetDAO.getAll();
        if (kpacSets.isEmpty()) {
            log.warn("In getAll - no kpacSets was found");
        }
        log.info("In getAll - {} kpacSets was found",kpacSets.size());
        return kpacSets;
    }

    @Override
    public KpacSet getById(Integer id) {
        KpacSet kpacSet = kpacSetDAO.getById(id);
        if (kpacSet == null) {
            log.warn("In getById - KpacSet with id: {} was not found ",id);
            throw new EntityNotFoundException(KpacSet.class, "id", id.toString());
        }
        log.info("In getById - KpacSet with id: {} was found ", id);
        return kpacSet;
    }

    @Override
    public KpacSetDTO getByIdDTO(Integer id) {
        KpacSet kpacSet = kpacSetDAO.getById(id);
        if (kpacSet == null) {
            log.warn("In getByIdDTO - KpacSet with id: {} was not found ",id);
            throw new EntityNotFoundException(KpacSet.class, "id", id.toString());
        }
        log.info("In getByIdDTO - KpacSet with id: {} was found ", id);
        return kpacSetDTOMapper.toDTO(kpacSet);
    }

    @Override
    @Transactional
    public void save(KpacSetDTO kpacSet) {
        KpacSet kpacSetCandidate = kpacSetDTOMapper.toEntity(kpacSet);
        Integer setId = kpacSetDAO.save(kpacSetCandidate);
        log.info("In save - kpacSet:{} was saved",kpacSet);
        if (kpacSet.getKpacId() != null) {
            Integer kpacId = kpacSet.getKpacId();
            Kpac kpac = kpacService.getById(kpacId);
            if (kpac == null) {
                log.warn("In save - kpac with id : {} was not found",kpacId);
                throw new EntityNotFoundException(Kpac.class,"id",kpacId.toString());
            }
            KpacSetKpac kpacSetKpac = KpacSetKpac.builder().kpacSetId(setId).kpacId(kpacId).build();
            kpacSetKpacService.save(kpacSetKpac);
            log.info("In save - kpacSetKpac : {} was saved",kpacSetKpac);
        }
    }

    @Override
    public void save(KpacSet kpacSet) {
        kpacSetDAO.save(kpacSet);
        log.info("In save - kpacSet : {} was saved",kpacSet);
    }

    @Override
    public void deleteById(Integer id) {
        kpacSetDAO.deleteById(id);
        log.info("In deleteById - kpacSet with id : {} was deleted",id);
    }
}
