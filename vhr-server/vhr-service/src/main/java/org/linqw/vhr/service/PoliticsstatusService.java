package org.linqw.vhr.service;

import org.linqw.vhr.mapper.PoliticsstatusMapper;
import org.linqw.vhr.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsstatusService {
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticStatus() {

        return politicsstatusMapper.getAllPoliticStatus();
    }
}
