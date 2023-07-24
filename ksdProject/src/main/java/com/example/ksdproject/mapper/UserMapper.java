package com.example.ksdproject.mapper;

import com.example.ksdproject.dto.UserRequest;
import com.example.ksdproject.dto.UserResponse;
import com.example.ksdproject.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE , componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequest userRequest);
    UserResponse toDto(User user);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserRequest userRequest , @MappingTarget User user);
    List<UserResponse> toUserResponseList(List<User> userList);

}
