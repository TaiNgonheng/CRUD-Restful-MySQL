package Restful_Webservice.Spring.Boot.service.impl;

import Restful_Webservice.Spring.Boot.dto.UserDto;
import Restful_Webservice.Spring.Boot.entity.User;
import Restful_Webservice.Spring.Boot.mapper.AutoUserMapper;
import Restful_Webservice.Spring.Boot.mapper.UserMapper;
import Restful_Webservice.Spring.Boot.repository.UserRepository;
import Restful_Webservice.Spring.Boot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
//        User user = modelMapper.map(userDto,User.class);
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        UserDto saveUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return saveUserDto;
    }

    @Override
    public UserDto getUserByID(Long userId) {
       Optional<User> optionalUser= userRepository.findById(userId);
        User user= optionalUser.get();
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user)->AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).get();
//        existingUser.setId(user.getId());
        existingUser.setFirstname(userDto.getFirstname());
        existingUser.setLastname(userDto.getLastname());
        existingUser.setEmail(userDto.getEmail());
        return AutoUserMapper.MAPPER.mapToUserDto(userRepository.save(existingUser));
//        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
