package org.linqw.vhr.controller.salary;

import org.linqw.vhr.model.Employee;
import org.linqw.vhr.model.RespBean;
import org.linqw.vhr.model.RespPageBean;
import org.linqw.vhr.model.Salary;
import org.linqw.vhr.service.EmployeeService;
import org.linqw.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/salary/sobcfg")
public class sobCfgController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeWithSalaryByPage(@RequestParam(defaultValue = "1") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        return employeeService.getEmployeeWithSalaryByPage(page, size);
    }

    @GetMapping("/salaries")
    public List<Salary> getEmployeeSalaries() {
        return salaryService.getAllSalarySob();
    }

    @PutMapping("/")
    public RespBean updateEmployeeSalaryById(Integer eid, Integer sid) {
        Integer result = employeeService.updateEmployeeWithSalarybyId(eid, sid);
        if (result == 1 || result == 2) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
