package com.misterkourouma.trainings.springbootrestapi.service;

import com.misterkourouma.trainings.springbootrestapi.dto.UserDto;
import com.misterkourouma.trainings.springbootrestapi.model.User;

import java.util.List;

public interface UserService {

    UserDto createStudent(UserDto userDto);

    UserDto getUser(long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    void deleteUser(long id);
}
