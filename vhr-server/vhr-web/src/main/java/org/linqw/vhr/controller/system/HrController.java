package org.linqw.vhr.controller.system;

import org.linqw.vhr.model.Hr;
import org.linqw.vhr.model.RespBean;
import org.linqw.vhr.model.Role;
import org.linqw.vhr.service.HrService;
import org.linqw.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
    @PutMapping("/updateHrRoles")
    public RespBean updateHrRoles(Integer hrid,Integer[] roles){
        if(hrService.updateHrRoles(hrid,roles)){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id){
        if (hrService.deleteHrById(id)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
