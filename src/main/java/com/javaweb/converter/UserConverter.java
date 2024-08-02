package com.javaweb.converter;

import com.javaweb.dto.UserRequireDTO;
import com.javaweb.dto.UserResponseDTO;
import com.javaweb.entity.Role;
import com.javaweb.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserConverter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;
    public UserResponseDTO toUserResponseDTO(User user) {
        UserResponseDTO userDTO = modelMapper.map(user, UserResponseDTO.class);
        return userDTO;
    }
    public User toUser(UserResponseDTO userResponseDTO) {
        User user = modelMapper.map(userResponseDTO, User.class);
        return user;
    }
    public User toUser(UserRequireDTO userRequireDTO) {
        User user = modelMapper.map(userRequireDTO, User.class);
        Date dateTime = new Date();
        user.setIsActive(true);
        user.setStatus("Chưa xác nhận");
        user.setCreatedDate(dateTime);
        user.setCreatedBy(userRequireDTO.getFullName());
        // mã hóa
        String password = userRequireDTO.getPassWord();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassWord(encodedPassword);
        return user;
    }
}
