package Restful_Webservice.Spring.Boot.service.impl;

import Restful_Webservice.Spring.Boot.dto.UserDto;
import Restful_Webservice.Spring.Boot.entity.User;
import Restful_Webservice.Spring.Boot.mapper.UserMapper;
import Restful_Webservice.Spring.Boot.repository.UserRepository;
import Restful_Webservice.Spring.Boot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        UserDto saveUserDto = UserMapper.mapToUserDto(userRepository.save(user));
        return saveUserDto;
    }

    @Override
    public User getUserByID(Long userId) {
       Optional<User> optionalUser= userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
//        existingUser.setId(user.getId());
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
