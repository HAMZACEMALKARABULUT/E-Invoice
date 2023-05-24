package com.izibiz.service.mapper;

import com.izibiz.repository.entity.RoleEntity;
import com.izibiz.service.domain.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-10T20:22:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleEntity fromDomainToEntity(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( role.getId() );
        roleEntity.setRoleName( role.getRoleName() );

        return roleEntity;
    }

    @Override
    public Role fromEntityToDomain(RoleEntity RoleEntity) {
        if ( RoleEntity == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( RoleEntity.getId() );
        role.setRoleName( RoleEntity.getRoleName() );

        return role;
    }

    @Override
    public List<Role> fromListEntityToDomain(List<RoleEntity> roleEntityList) {
        if ( roleEntityList == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( roleEntityList.size() );
        for ( RoleEntity roleEntity : roleEntityList ) {
            list.add( fromEntityToDomain( roleEntity ) );
        }

        return list;
    }
}
