package org.linqw.vhr.controller.emp;

import org.linqw.vhr.model.*;
import org.linqw.vhr.service.*;
import org.linqw.vhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticsstatusService politicsstatusService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          Employee employee,
                                          Date[] beginDateScope){
//        System.out.println(employee);
//        System.out.println(Arrays.toString(beginDateScope));
        return employeeService.getEmployeeByPage(page,size,employee,beginDateScope);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee){
        if (employeeService.addEmp(employee)==1){
            return RespBean.ok("添加成功");
        }
        return  RespBean.error("添加失败");
    }

    @GetMapping("/nation")
    public List<Nation> getAllNations(){
        return nationService.getAllNations();
    }

    @GetMapping("/politics")
    public List<Politicsstatus> getAllPoliticStatus(){
        return politicsstatusService.getAllPoliticStatus();
    }
    @GetMapping("/jobLevels")
    public List<JobLevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }
    @GetMapping("/positions")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }
    @GetMapping("/maxWorkID")
    public RespBean getMaxWorkID(){
        return RespBean.build().setStatus(200)
                .setObject(String.format("%08d",employeeService.getMaxWorkID()+1));
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }
    @DeleteMapping("/{id}")
    public RespBean deleteEmpById(@PathVariable Integer id){
        if(employeeService.deleteEmpId(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee){
        if(employeeService.updateEmp(employee)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> employees = ((List<Employee>) employeeService.getEmployeeByPage(null, null, null,null).getData());
        return POIUtils.employees2Excel(employees);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException{
//        file.transferTo(new File("/Users/linqw/IdeaProjects/vhr/employees.xls"));
        List<Employee> list = POIUtils.excel2employee(file,nationService.getAllNations()
                ,politicsstatusService.getAllPoliticStatus(),departmentService.getAllDepartmentsWithoutChildren(),
                positionService.getAllPositions(),jobLevelService.getAllJobLevels());
        if(employeeService.addEmps(list)==list.size()){
            return RespBean.ok("上传成功!");
        }else {
            return RespBean.error("上传失败！");
        }
    }
}
