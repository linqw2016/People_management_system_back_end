package org.linqw.vhr.service;

import org.linqw.vhr.mapper.RoleMapper;
import org.linqw.vhr.model.Menu;
import org.linqw.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles(){
        return roleMapper.getAllRoles();
    }

    public int addRole(Role role) {
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRoleById(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
