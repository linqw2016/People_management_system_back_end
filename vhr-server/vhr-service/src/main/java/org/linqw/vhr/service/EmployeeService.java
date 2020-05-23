package org.linqw.vhr.service;

import org.linqw.vhr.mapper.EmployeeMapper;
import org.linqw.vhr.model.Employee;
import org.linqw.vhr.model.RespBean;
import org.linqw.vhr.model.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat=new DecimalFormat("##.00");

    public final static Logger logger = LoggerFactory.getLogger(EmployeeService.class);



    //获取第page页的size个数;
    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee,Date[] beginDateScope) {
        if(page!=null&size!=null){
            page=(page-1)*size;
        }
        List<Employee> list=employeeMapper.getEmployByPage(page,size,employee,beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(list);
        bean.setTotal(employeeMapper.getTotal(employee,beginDateScope));

        return bean;

    }

    public Integer addEmp(Employee employee) {
        Date BeginDate = employee.getBeginDate();
        Date EndDate = employee.getEndContract();
        double month_cos = (Double.parseDouble(yearFormat.format(BeginDate)) - Double.parseDouble(yearFormat.format(EndDate)))
                * 12 + (Double.parseDouble(monthFormat.format(BeginDate)) - Double.parseDouble(monthFormat.format(EndDate)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(-month_cos/12)));
        int result = employeeMapper.insertSelective(employee);
        if(result==1){
            Employee emp=employeeMapper.getEmployeeById(employee.getId());
            rabbitTemplate.convertAndSend("linqw.mail.welcome",emp);
            logger.info(emp.toString());
        }
        return result;
    }

    public Integer getMaxWorkID() {
        return  employeeMapper.getMaxWorkID();
    }

    public Integer deleteEmpId(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }

    public RespPageBean getEmployeeWithSalaryByPage(Integer page, Integer size) {
        if(page!=null&& size!=null){
            page=(page-1)*size;
        }
        List<Employee> list=employeeMapper.getEmployeeWithSalaryByPage(page,size);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setTotal(employeeMapper.getTotal(null,null));
        respPageBean.setData(list);

        return respPageBean;

    }

    public Integer updateEmployeeWithSalarybyId(Integer eid, Integer sid) {
        return employeeMapper.updateEmployeeWithSalarybyId(eid,sid);

    }
}
