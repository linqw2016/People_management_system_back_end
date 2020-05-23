package org.linqw.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.linqw.vhr.model.Employee;
import org.linqw.vhr.model.Hr;
import org.linqw.vhr.model.Role;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hRid") Integer hRid, @Param("keywords") String keywords);

    List<Employee> getAllHrsExceptCurrentHr(Integer id);
}