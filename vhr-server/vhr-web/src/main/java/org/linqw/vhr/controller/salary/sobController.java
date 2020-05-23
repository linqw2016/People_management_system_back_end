package org.linqw.vhr.controller.salary;

import org.linqw.vhr.model.RespBean;
import org.linqw.vhr.model.Salary;
import org.linqw.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sob")
public class sobController {
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalarySob(){
        return salaryService.getAllSalarySob();
    }

    @PostMapping("/")
    public RespBean addSob(@RequestBody Salary salary){
        if(salaryService.addSob(salary)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteSob(@PathVariable Integer id){
        if(salaryService.deleteSobById(id)==1){
            return RespBean.ok("删除套账成功");
        }
        return RespBean.error("删除套账失败！");
    }

    @PutMapping("/")
    public RespBean updateSobById(@RequestBody Salary salary){
        if(salaryService.updateSobById(salary)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败");
    }
    @DeleteMapping("/")
    public RespBean deleteSalaryByIds(Integer[] ids){
        if(salaryService.deleteSalaryByIds(ids)==ids.length){
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("删除失败！");

    }


}
