package org.linqw.vhr.service;

import org.linqw.vhr.mapper.SalaryMapper;
import org.linqw.vhr.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalaryService {
    @Autowired
    SalaryMapper salaryMapper;


    public List<Salary> getAllSalarySob() {
        return salaryMapper.getAllSalarySob();
    }

    public Integer addSob(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public int deleteSobById(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public int updateSobById(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }


    public int deleteSalaryByIds(Integer[] ids) {
        return salaryMapper.deleteSalaryByIds(ids);
    }
}
