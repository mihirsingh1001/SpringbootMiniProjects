package com.project.usermodule.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.usermodule.dtos.LoginDto;
import com.project.usermodule.dtos.UserDto;
import com.project.usermodule.entities.Users;
import com.project.usermodule.repository.UserRepository;
import com.project.usermodule.services.User;

@Service
public class UserImpl implements User {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto registerUser(UserDto userdto) {
        userdto.setPassword(passwordEncoder.encode(userdto.getPassword()));
        Users userInfo = dtoToEntity(userdto);
        Users userInfoSaved = userRepository.save(userInfo);
        UserDto savedUserInfo = entityToDto(userInfoSaved);
        return savedUserInfo;
    }

    @Override
    public List<UserDto> allUsers() {
        List<Users> allUsers = userRepository.findAll();
        List<UserDto> users = allUsers.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return users;
    }

    @Override
    public Boolean isLoginUser(LoginDto loginDto) {
        Optional<Users> userEmail = userRepository.findByEmail(loginDto.getEmail());
        if (userEmail == null) {
            return false;
        }
        Users user = userEmail.get();
        if (!user.getPassword().equals(loginDto.getPassword())) {
            return false;
        }
        return true;
    }

    public UserDto entityToDto(Users user) {
        return mapper.map(user, UserDto.class);

    }

    public Users dtoToEntity(UserDto userdto) {
        return mapper.map(userdto, Users.class);

    }

}
