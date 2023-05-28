package com.misterkourouma.trainings.springbootrestapi.controller;

import com.misterkourouma.trainings.springbootrestapi.dto.UserDto;
import com.misterkourouma.trainings.springbootrestapi.exception.ErrorDetails;
import com.misterkourouma.trainings.springbootrestapi.exception.ResourceNotFoundException;
import com.misterkourouma.trainings.springbootrestapi.model.User;
import com.misterkourouma.trainings.springbootrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    // http://localhost:8080/student
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getStudent(@PathVariable("id") int userId){

        UserDto userDto = userService.getUser(userId);
     //  return ResponseEntity.ok().header("custom-header","this is a custom headerb").body(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createStudent(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createStudent(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("id") int userId){
        userDto.setId(userId);
        return ResponseEntity.ok(userService.updateUser(userDto));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

/*    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){

        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(LocalDateTime.now())
                .message(exception.getMessage())
                .path(request.getDescription(false))
                .errorCode("USER_NOT_FOUND")
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }*/
}
