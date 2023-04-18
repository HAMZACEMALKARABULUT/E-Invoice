package com.staj.proje.service;

import com.staj.proje.dao.RoleDao;
import com.staj.proje.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public List<Role> listRoles(){

        return roleDao.findAll();


    }



    public Role findRoleById(Long roleId) {
        return roleDao.findRoleById(roleId);
    }
}
