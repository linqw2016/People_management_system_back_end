package org.linqw.vhr.controller.system.basic;

import org.linqw.vhr.model.JobLevel;
import org.linqw.vhr.model.RespBean;
import org.linqw.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/jobL")
public class JobLevelController {
    @Autowired
    JobLevelService JobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return JobLevelService.getAllJobLevels();
    }

    //@RequestBody注解表示以JSON传递值；
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel JobLevel) {
        if (JobLevelService.addJobLevel(JobLevel) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel JobLevel) {
        if (JobLevelService.updateJobLevel(JobLevel) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (JobLevelService.deleteJobLevelById(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelsByIds(Integer[] ids){
        if(JobLevelService.deleteJobLevelByIds(ids)==ids.length){
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("删除失败！");

    }
    
}
