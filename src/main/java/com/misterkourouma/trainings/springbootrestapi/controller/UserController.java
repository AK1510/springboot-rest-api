package com.misterkourouma.trainings.springbootrestapi.controller;

import com.misterkourouma.trainings.springbootrestapi.dto.UserDto;
import com.misterkourouma.trainings.springbootrestapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs  - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users  REST API is used to get all users from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }


    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User By ID REST API is used to get user from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getStudent(@PathVariable("id") int userId) {

        UserDto userDto = userService.getUser(userId);
        //  return ResponseEntity.ok().header("custom-header","this is a custom headerb").body(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<UserDto> createStudent(@RequestBody @Valid UserDto userDto) {
        UserDto savedUser = userService.createStudent(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update user from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("id") int userId) {
        userDto.setId(userId);
        return ResponseEntity.ok(userService.updateUser(userDto));
    }

     //@ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete user from a database"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 NO_CONTENT"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.NO_CONTENT);
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
