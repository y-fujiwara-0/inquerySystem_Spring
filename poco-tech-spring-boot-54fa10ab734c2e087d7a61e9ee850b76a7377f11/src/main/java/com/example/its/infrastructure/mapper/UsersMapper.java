package com.example.its.infrastructure.mapper;

import com.example.its.domain.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    Users toModel(com.example.its.infrastructure.entity.Users entity);

    //List<Users> toModel(List<com.example.its.infrastructure.entity.Users> entities);

    Users mapToDomain(com.example.its.infrastructure.entity.Users entity);

    //Users mapToEntity(com.example.its.infrastructure.entity.Users entity);

    @Mapping(target = "userId", source = "users.userId")
    com.example.its.infrastructure.entity.Users mapToEntity(Users users);
}



