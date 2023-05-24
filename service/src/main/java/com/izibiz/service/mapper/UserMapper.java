package com.izibiz.service.mapper;

import com.izibiz.repository.entity.UserEntity;
import com.izibiz.service.domain.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

   UserEntity fromDomainToEntity(User user);
    User fromEntityToDomain(UserEntity userEntity);
    List<User> fromListEntityToDomain(List<UserEntity> userEntityList);
}
