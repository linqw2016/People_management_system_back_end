package org.linqw.vhr.controller.system.basic;

import org.linqw.vhr.model.Menu;
import org.linqw.vhr.model.RespBean;
import org.linqw.vhr.model.Role;
import org.linqw.vhr.service.MenuService;
import org.linqw.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {
    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid){
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        if(menuService.updateMenuRole(rid,mids)){
            return RespBean.ok("更新成功");
        }else{
            return RespBean.error("删除失败");
        }
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if(roleService.addRole(role)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid){
        if(roleService.deleteRoleById(rid)==1){
            return RespBean.ok("删除成功");
        }else {
            return RespBean.error("删除失败");
        }
    }


}
