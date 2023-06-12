package com.izibiz.service.mapper;

import com.izibiz.repository.entity.RoleEntity;
import com.izibiz.repository.entity.UserEntity;
import com.izibiz.service.domain.Role;
import com.izibiz.service.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T21:53:48+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity fromDomainToEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setName( user.getName() );
        userEntity.setSurname( user.getSurname() );
        userEntity.setMail( user.getMail() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setRole( roleListToRoleEntityList( user.getRole() ) );

        return userEntity;
    }

    @Override
    public User fromEntityToDomain(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setId( userEntity.getId() );
        user.setName( userEntity.getName() );
        user.setSurname( userEntity.getSurname() );
        user.setMail( userEntity.getMail() );
        user.setPassword( userEntity.getPassword() );
        user.setRole( roleEntityListToRoleList( userEntity.getRole() ) );

        return user;
    }

    @Override
    public List<User> fromListEntityToDomain(List<UserEntity> userEntityList) {
        if ( userEntityList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userEntityList.size() );
        for ( UserEntity userEntity : userEntityList ) {
            list.add( fromEntityToDomain( userEntity ) );
        }

        return list;
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
