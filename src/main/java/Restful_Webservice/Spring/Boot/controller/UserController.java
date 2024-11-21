package Restful_Webservice.Spring.Boot.controller;

import Restful_Webservice.Spring.Boot.dto.UserDto;
import Restful_Webservice.Spring.Boot.entity.User;
import Restful_Webservice.Spring.Boot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    //build create user Rest API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
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
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("id") Long userId){
       userDto.setId(userId);
//       User update= userService.updateUser(user);
       return ResponseEntity.ok(userService.updateUser(userDto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully delete",HttpStatus.OK);
    }
}
