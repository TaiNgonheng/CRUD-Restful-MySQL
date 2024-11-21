package Restful_Webservice.Spring.Boot.service;

import Restful_Webservice.Spring.Boot.dto.UserDto;
import Restful_Webservice.Spring.Boot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    User getUserByID(Long userId);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUser(Long userId);
}
