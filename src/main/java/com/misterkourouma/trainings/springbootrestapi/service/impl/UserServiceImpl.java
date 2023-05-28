package com.misterkourouma.trainings.springbootrestapi.service.impl;

import com.misterkourouma.trainings.springbootrestapi.dto.UserDto;
import com.misterkourouma.trainings.springbootrestapi.exception.EmailAlreadyExistsException;
import com.misterkourouma.trainings.springbootrestapi.exception.ResourceNotFoundException;
import com.misterkourouma.trainings.springbootrestapi.mapper.UserMapper;
import com.misterkourouma.trainings.springbootrestapi.model.User;
import com.misterkourouma.trainings.springbootrestapi.repository.UserRepository;
import com.misterkourouma.trainings.springbootrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto createStudent(UserDto userDto) {

        Optional<User>  userOptional = userRepository.findByEmail(userDto.getEmail());
        if(userOptional.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists for User");
        }

        //User user = UserMapper.mapToUser(userDto);
        User user = modelMapper.map(userDto, User.class);
        return UserMapper.mapToUserDto(userRepository.save(user));
    }

    @Override
    public UserDto getUser(long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
       // return UserMapper.mapToUserDto(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserMapper::mapToUserDto).toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {

        User existingUser = userRepository.findById(user.getId()).orElseThrow(()-> new ResourceNotFoundException("User", "id",  user.getId()));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        return UserMapper.mapToUserDto( userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", id)
        );
        userRepository.deleteById(id);
    }
}
