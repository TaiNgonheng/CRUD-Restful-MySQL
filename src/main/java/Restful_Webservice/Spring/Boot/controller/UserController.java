package Restful_Webservice.Spring.Boot.controller;

import Restful_Webservice.Spring.Boot.dto.UserDto;
import Restful_Webservice.Spring.Boot.exception.ErrorDetails;
import Restful_Webservice.Spring.Boot.exception.ResourceNotFoundException;
import Restful_Webservice.Spring.Boot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name="CRUD REST API FOR USER Resource",
        description = "Create user, Get User, Update User, Get all User, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    //build create user Rest API
    @Operation(
            summary = "Create User Rest API",
            description = "Create User Rest API is used to save user in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto saveUser= userService.createUser(user);
        return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get User Rest API",
            description = "Get Single User Rest API is used to Get user in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
//        User getUser = userService.getUserByID(userId);
        return ResponseEntity.ok(userService.getUserByID(userId));
    }
    @Operation(
            summary = "Get All User Rest API",
            description = "Get All User Rest API is used to get user in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 get"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
//        List<User> users=userService.getAllUser();
        return ResponseEntity.ok(userService.getAllUser());
    }
    @Operation(
            summary = "Update User Rest API",
            description = "Update User Rest API is used to update user in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto userDto,@PathVariable("id") Long userId){
       userDto.setId(userId);
//       User update= userService.updateUser(user);
       return ResponseEntity.ok(userService.updateUser(userDto));
    }
    @Operation(
            summary = "Delete User Rest API",
            description = "Delete User Rest API is used to delete user in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully delete",HttpStatus.OK);
    }
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }
}
