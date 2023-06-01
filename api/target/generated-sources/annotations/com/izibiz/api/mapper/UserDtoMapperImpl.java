package com.izibiz.api.mapper;

import com.izibiz.api.dto.UserDto;
import com.izibiz.repository.entity.RoleEntity;
import com.izibiz.service.domain.Role;
import com.izibiz.service.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T18:34:49+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class UserDtoMapperImpl implements UserDtoMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setSurname( user.getSurname() );
        userDto.setMail( user.getMail() );
        userDto.setPassword( user.getPassword() );
        userDto.setRole( roleListToRoleEntityList( user.getRole() ) );

        return userDto;
    }

    @Override
    public User toDomain(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setName( userDto.getName() );
        user.setSurname( userDto.getSurname() );
        user.setMail( userDto.getMail() );
        user.setPassword( userDto.getPassword() );
        user.setRole( roleEntityListToRoleList( userDto.getRole() ) );

        return user;
    }

    protected RoleEntity roleToRoleEntity(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( role.getId() );
        roleEntity.setRoleName( role.getRoleName() );

        return roleEntity;
    }

    protected List<RoleEntity> roleListToRoleEntityList(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleEntity> list1 = new ArrayList<RoleEntity>( list.size() );
        for ( Role role : list ) {
            list1.add( roleToRoleEntity( role ) );
        }

        return list1;
    }

    protected Role roleEntityToRole(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleEntity.getId() );
        role.setRoleName( roleEntity.getRoleName() );

        return role;
    }

    protected List<Role> roleEntityListToRoleList(List<RoleEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Role> list1 = new ArrayList<Role>( list.size() );
        for ( RoleEntity roleEntity : list ) {
            list1.add( roleEntityToRole( roleEntity ) );
        }

        return list1;
    }
}
