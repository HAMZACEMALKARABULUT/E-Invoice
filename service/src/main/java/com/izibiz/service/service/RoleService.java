package com.izibiz.service.service;


import com.izibiz.repository.repository.RoleRepository;
import com.izibiz.repository.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<RoleEntity> listRoles(){

        return roleRepository.findAll();
    }



    public RoleEntity findRoleById(Long roleId) {
        return roleRepository.findRoleById(roleId);
    }
}
