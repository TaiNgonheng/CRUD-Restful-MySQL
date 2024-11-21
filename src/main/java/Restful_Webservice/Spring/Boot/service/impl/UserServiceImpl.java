package Restful_Webservice.Spring.Boot.service.impl;

import Restful_Webservice.Spring.Boot.dto.UserDto;
import Restful_Webservice.Spring.Boot.entity.User;
import Restful_Webservice.Spring.Boot.exception.EmailAlreadyExistsException;
import Restful_Webservice.Spring.Boot.exception.ResourceNotFoundException;
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
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already exists for User");
        }

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        UserDto saveUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
        return saveUserDto;
    }

    @Override
    public UserDto getUserByID(Long userId) {
       User user = userRepository.findById(userId).orElseThrow(
               ()->new ResourceNotFoundException("User","id",userId)
       );
//        User user= optionalUser.get();
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user)->AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).orElseThrow(
                ()->new ResourceNotFoundException("User","id",userDto.getId())
        );
//        existingUser.setId(user.getId());
        existingUser.setFirstname(userDto.getFirstname());
        existingUser.setLastname(userDto.getLastname());
        existingUser.setEmail(userDto.getEmail());
        return AutoUserMapper.MAPPER.mapToUserDto(userRepository.save(existingUser));
//        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User","id",userId)
        );
        userRepository.deleteById(userId);
    }
}
