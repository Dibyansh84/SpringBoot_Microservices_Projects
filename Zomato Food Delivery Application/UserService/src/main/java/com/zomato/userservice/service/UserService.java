package com.zomato.userservice.service;

import com.zomato.userservice.DTO.UserDto;

public interface UserService
{
    //Add a user
    UserDto createUser(UserDto userDto);

//    //Update a user
//    UserDto updateUserInfo(Long id, UserDto userDto);
}
