package com.project.usermodule.services;

import java.util.List;

import com.project.usermodule.dtos.LoginDto;
import com.project.usermodule.dtos.UserDto;

public interface User {

    public UserDto registerUser(UserDto userdto);

    public Boolean isLoginUser(LoginDto loginDto);

    public List<UserDto> allUsers();
}
