package com.zomato.userservice.serviceImpl;

import com.zomato.userservice.DTO.UserDto;
import com.zomato.userservice.entity.User;
import com.zomato.userservice.repository.UserRepository;
import com.zomato.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto)
    {
        //Convert DTO to entity.
        User user = convertDtoToEntity(userDto);
        User savedUser = userRepository.save(user);

        //Convert entity to DTO.
        return convertEntityToDto(savedUser);
    }
    //Convert DTO to entity
    private User convertDtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    //Convert entity to DTO.
    private UserDto convertEntityToDto(User user)
    {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
