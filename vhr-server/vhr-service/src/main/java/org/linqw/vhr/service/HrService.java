package org.linqw.vhr.service;

import org.linqw.vhr.mapper.HrMapper;
import org.linqw.vhr.mapper.HrRoleMapper;
import org.linqw.vhr.model.Employee;
import org.linqw.vhr.model.Hr;
import org.linqw.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr=hrMapper.loadUserByUsername(username);
        if(hr==null){
            throw new UsernameNotFoundException("用户名不存在！");
        }

        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }


    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public boolean updateHrRoles(Integer hrid, Integer[] roles) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRoles(hrid,roles)==roles.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    public List<Employee> getAllHrsExceptCurrentHr() {

        return hrMapper.getAllHrsExceptCurrentHr(HrUtils.getCurrentHr().getId());
    }
}
