package org.linqw.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.linqw.vhr.model.Salary;

import java.util.List;

public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> getAllSalarySob();

    Integer deleteSalaryByIds(@Param("ids") Integer[] ids);
}