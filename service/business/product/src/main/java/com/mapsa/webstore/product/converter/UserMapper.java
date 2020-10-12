package com.mapsa.webstore.product.converter;

import com.mapsa.webstore.product.domain.User;
import com.mapsa.webstore.product.security.RegisterRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper instance= Mappers.getMapper(UserMapper.class);
    //@Mapping(target = "User.roles",source = "role")
    User registerDtoToUser(RegisterRequestDto requestDto);
}
