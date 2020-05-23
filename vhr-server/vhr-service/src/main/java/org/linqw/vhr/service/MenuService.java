package org.linqw.vhr.service;

import org.linqw.vhr.mapper.MenuMapper;
import org.linqw.vhr.mapper.MenuRoleMapper;
import org.linqw.vhr.model.Hr;
import org.linqw.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }


    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

//    @Cacheable
    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();

    }

    public List<Menu> getAllMenus() {

        return menuMapper.getAllMenus();
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {

        menuRoleMapper.deleteByRid(rid);
        if(mids==null||mids.length==0){
            return true;
        }
        Integer result = menuRoleMapper.insertRecords(rid,mids);
        return result==mids.length;
    }
}
