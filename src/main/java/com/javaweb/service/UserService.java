package com.javaweb.service;

import com.javaweb.customexceptions.PermissionDenyException;
import com.javaweb.dto.UserRequireDTO;
import com.javaweb.dto.UserResponseDTO;
import com.javaweb.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAllUser();
    void saveUser(UserResponseDTO userResponseDTO);
    UserResponseDTO getUserById(Long id);
    void saveActiveUser(Long id, Integer active);
    void deleteUser(Long id);
    User createUser(UserRequireDTO userRequireDTO) throws PermissionDenyException;
    String login(String nameUser, String password) throws Exception;
    UserResponseDTO getNameUserAndActive(String s);
    void saveRoleUser(Long id, String roleName);
}
