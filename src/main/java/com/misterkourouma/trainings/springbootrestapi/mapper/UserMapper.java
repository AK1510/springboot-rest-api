package com.misterkourouma.trainings.springbootrestapi.mapper;

import com.misterkourouma.trainings.springbootrestapi.dto.UserDto;
import com.misterkourouma.trainings.springbootrestapi.model.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public static User mapToUser(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();
    }
}
