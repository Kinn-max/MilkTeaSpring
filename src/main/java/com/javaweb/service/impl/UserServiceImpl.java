package com.javaweb.service.impl;

import com.javaweb.converter.UserConverter;
import com.javaweb.customexceptions.DataNotFoundException;
import com.javaweb.customexceptions.PermissionDenyException;
import com.javaweb.dto.UserRequireDTO;
import com.javaweb.dto.UserResponseDTO;
import com.javaweb.entity.Role;
import com.javaweb.entity.User;
import com.javaweb.repository.RoleRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<UserResponseDTO> getAllUser() {
        List<User> listUser = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user : listUser) {
            UserResponseDTO  userResponseDTO = userConverter.toUserResponseDTO(user);
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    @Override
    public void saveUser(UserResponseDTO userResponseDTO) {
        User user = new User();
        if(userResponseDTO.getId() != null){
            user = userRepository.findById(userResponseDTO.getId()).get();
        }

        user = userConverter.toUser(userResponseDTO);
        userRepository.save(user);
        }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user =  userRepository.findById(id).get();
        UserResponseDTO userResponseDTO =userConverter.toUserResponseDTO(user);
        return userResponseDTO;
    }

    @Override
    public void saveActiveUser(Long id, Integer active) {
        User user =  userRepository.findById(id).get();
        Boolean status = active != 0;
        user.setIsActive(status);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User createUser(UserRequireDTO userRequireDTO) throws PermissionDenyException {
        //register user
        String userName = userRequireDTO.getNameUser();
        String email = userRequireDTO.getEmail();
        // Kiểm tra user and email
        if(userRepository.existsByNameUser(userName)) {
            throw new DataIntegrityViolationException("Tên người dùng đã tồn tại");
        }
        if(userRepository.existsByEmail(email)) {
            throw new DataIntegrityViolationException("Email đã tồn tại");
        }
        Role role = roleRepository.findById(userRequireDTO.getRoleId())
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy role"));
        if(role.getName().toUpperCase().equals(Role.ADMIN)) {
            throw new PermissionDenyException("Bạn không thể đăng ký một tài khoản admin");
        }
        User user = userConverter.toUser(userRequireDTO);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public String login(String nameUser, String password) throws Exception {
//        Optional<User> optionalUser = userRepository.findByNameUser(nameUser);
//        if(optionalUser == null) {
//            throw new DataNotFoundException("Tài khoản chưa được đăng ký");
//        }
//        //return optionalUser.get();//muốn trả JWT token ?
//        User existingUser = optionalUser.get();
//        //check password
//        if(!passwordEncoder.matches(password, existingUser.getPassword())) {
//                throw new BadCredentialsException("Tài khoản hoặc mật khẩu không đúng");
//        }
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(nameUser, password, existingUser.getAuthorities());
//        //authenticate with Java Spring security
//        authenticationManager.authenticate(authenticationToken);
//        return jwtTokenUtil.generateToken(existingUser);
        return null;
    }

    @Override
    public UserResponseDTO getNameUserAndActive(String s) {
        User user= userRepository.findNameUserAndActive(s);
        UserResponseDTO userResponseDTO =userConverter.toUserResponseDTO(user);
        return userResponseDTO;
    }

    @Override
    public void saveRoleUser(Long id, String roleName) {
        User user = userRepository.findById(id).get();
        Role role = roleRepository.findByName(roleName);
        if (role != null){
            user.setRole(role);
            user.setStatus(roleName);
            userRepository.save(user);
        }
    }
}
