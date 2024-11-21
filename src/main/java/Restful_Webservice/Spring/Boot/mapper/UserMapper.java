package Restful_Webservice.Spring.Boot.mapper;

import Restful_Webservice.Spring.Boot.dto.UserDto;
import Restful_Webservice.Spring.Boot.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        //Convert User Jpa Entity to UserDto
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
        return userDto;
    }
    //Convert UserDto to User jpa Entity
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getEmail()
        );
        return user;
    }
}
