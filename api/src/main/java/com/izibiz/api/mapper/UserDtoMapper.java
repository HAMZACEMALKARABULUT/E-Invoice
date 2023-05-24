package com.izibiz.api.mapper;

import com.izibiz.api.dto.UserDto;
import com.izibiz.service.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    UserDto toDto(User user);
    User toDomain(UserDto userDto);
}
