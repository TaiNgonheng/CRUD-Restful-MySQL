package Restful_Webservice.Spring.Boot.service;

import Restful_Webservice.Spring.Boot.dto.UserDto;
import Restful_Webservice.Spring.Boot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByID(Long userId);
    List<UserDto> getAllUser();
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long userId);
}
