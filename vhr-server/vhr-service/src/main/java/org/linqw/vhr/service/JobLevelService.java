package org.linqw.vhr.service;

import org.linqw.vhr.mapper.JobLevelMapper;
import org.linqw.vhr.model.JobLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {
    @Autowired
    JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }

    public Integer addJobLevel(JobLevel JobLevel) {
        JobLevel.setEnabled(true);
        JobLevel.setCreateDate(new Date());
        return jobLevelMapper.insertSelective(JobLevel);
    }

    public Integer updateJobLevel(JobLevel JobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(JobLevel);


    }

    public Integer deleteByPrimaryKey(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevelByIds(Integer[] ids) {
        return jobLevelMapper.deleteJobLevelByIds(ids);
    }

    public Integer deleteJobLevelById(Integer id) {

        return jobLevelMapper.deleteByPrimaryKey(id);
    }
}
