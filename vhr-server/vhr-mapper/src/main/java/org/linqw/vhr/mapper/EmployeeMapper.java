package org.linqw.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.linqw.vhr.model.Employee;
import org.springframework.security.core.parameters.P;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployByPage(@Param("page") Integer page,
                                   @Param("size") Integer size,
                                   @Param("employee") Employee employee,
                                   @Param("beginDateScope") Date[] beginDateScope);

    long getTotal(@Param("employee") Employee employee,@Param("beginDateScope") Date[] beginDateScope);

    Integer getMaxWorkID();

    Integer addEmps(@Param("list") List<Employee> list);

    Employee getEmployeeById(Integer id);

    List<Employee> getEmployeeWithSalaryByPage(@Param("page") Integer page, @Param("size") Integer size);

    Integer updateEmployeeWithSalarybyId(@Param("eid") Integer eid, @Param("sid") Integer sid);
}