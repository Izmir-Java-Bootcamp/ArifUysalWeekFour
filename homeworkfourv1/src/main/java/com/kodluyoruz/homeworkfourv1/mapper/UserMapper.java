package com.kodluyoruz.homeworkfourv1.mapper;

import com.kodluyoruz.homeworkfourv1.model.dto.UserDto;
import com.kodluyoruz.homeworkfourv1.model.entity.User;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")

public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    User createUser(CreateUpdateUserRequest request);

    UserDto toUserDto(User user);

    void updateUser(@MappingTarget User user, CreateUpdateUserRequest request);

    List<UserDto> toUserDtoList(List<User> users);
}
