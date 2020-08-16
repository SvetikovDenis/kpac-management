package com.svetikov.kpac.service.impl;

import com.svetikov.kpac.dao.KpacSetKpacDAO;
import com.svetikov.kpac.dto.KpacSetKpacDTO;
import com.svetikov.kpac.mapper.dto.KpacSetKpacDTOMapper;
import com.svetikov.kpac.model.KpacSetKpac;
import com.svetikov.kpac.service.KpacSetKpacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KpacSetKpacServiceImpl implements KpacSetKpacService {

    @Autowired
    private KpacSetKpacDAO kpacSetKpacDAO;

    @Autowired
    private KpacSetKpacDTOMapper kpacSetKpacDTOMapper;

    private final Logger log = LoggerFactory.getLogger(KpacSetKpacServiceImpl.class);

    @Override
    public List<KpacSetKpac> getAll() {
        List<KpacSetKpac> kpacSetKpacs = kpacSetKpacDAO.getAll();
        if (kpacSetKpacs.isEmpty()) {
            log.warn("In getAll - no kpacSetKpacs was found");
            return new ArrayList<>();
        }
        log.info("In getAll : {} kpacSetKpacs was found",kpacSetKpacs.size());
        return kpacSetKpacs;
    }

    @Override
    public List<KpacSetKpac> getAllBySetId(Integer id) {
        List<KpacSetKpac> kpacSetKpacs = kpacSetKpacDAO.getBySetId(id);
        if (kpacSetKpacs.isEmpty()) {
            log.warn("In getAllBySetId - no kpacSetKpacs was found for set with id : {}",id);
            return new ArrayList<>();
        }
        log.info("In getAllBySetId - {} kpacSetKpacs was found",kpacSetKpacs.size());
        return kpacSetKpacs;
    }

    @Override
    public void save(KpacSetKpac kpacSetKpac) {
        kpacSetKpacDAO.save(kpacSetKpac);
        log.info("In save - kpacSetKpac: {} was saved", kpacSetKpac);
    }

    @Override
    public void save(KpacSetKpacDTO kpacSetKpacDTO) {
        KpacSetKpac kpacSetKpac = kpacSetKpacDTOMapper.toEntity(kpacSetKpacDTO);
        kpacSetKpacDAO.save(kpacSetKpac);
        log.info("In save - kpacSetKpac: {} was saved", kpacSetKpac);
    }

    @Override
    public void delete(Integer setId, Integer kpacId) {
        KpacSetKpac kpacSetKpac = KpacSetKpac
                .builder()
                .kpacSetId(setId)
                .kpacId(kpacId)
                .build();

        kpacSetKpacDAO.delete(kpacSetKpac);
        log.info("In delete - kpacSetKpac: {} was deleted", kpacSetKpac);
    }

    @Override
    public void delete(KpacSetKpac kpacSetKpac) {
        kpacSetKpacDAO.delete(kpacSetKpac);
        log.info("In delete - kpacSetKpac: {} was deleted", kpacSetKpac);
    }

    @Override
    public void delete(Integer id) {
        kpacSetKpacDAO.delete(id);
        log.info("In delete - kpacSetKpac with id {} was deleted", id);
    }
}
