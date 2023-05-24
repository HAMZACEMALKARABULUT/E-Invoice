package com.izibiz.service.mapper;

import com.izibiz.repository.entity.RoleEntity;
import com.izibiz.service.domain.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface  RoleMapper {

    RoleEntity fromDomainToEntity(Role role);
    Role fromEntityToDomain(RoleEntity RoleEntity);
    List<Role> fromListEntityToDomain(List<RoleEntity> roleEntityList);
}
