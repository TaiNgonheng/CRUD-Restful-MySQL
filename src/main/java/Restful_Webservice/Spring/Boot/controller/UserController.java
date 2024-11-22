package Restful_Webservice.Spring.Boot.controller;

import Restful_Webservice.Spring.Boot.dto.UserDto;
import Restful_Webservice.Spring.Boot.exception.ErrorDetails;
import Restful_Webservice.Spring.Boot.exception.ResourceNotFoundException;
import Restful_Webservice.Spring.Boot.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    //build create user Rest API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto saveUser= userService.createUser(user);
        return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
//        User getUser = userService.getUserByID(userId);
        return ResponseEntity.ok(userService.getUserByID(userId));
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
//        List<User> users=userService.getAllUser();
        return ResponseEntity.ok(userService.getAllUser());
    }
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto userDto,@PathVariable("id") Long userId){
       userDto.setId(userId);
//       User update= userService.updateUser(user);
       return ResponseEntity.ok(userService.updateUser(userDto));
    }
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
