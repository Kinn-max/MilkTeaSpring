package com.javaweb.service.impl;

import com.javaweb.dto.MyUserDetail;
import com.javaweb.dto.UserResponseDTO;
import com.javaweb.entity.User;
import com.javaweb.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findNameUserAndActive(s);
        if(user == null){
            throw new UsernameNotFoundException(s);
        }
        MyUserDetail myUserDetail = new MyUserDetail(s,user.getPassword(),true,true,true,true,user.getAuthorities());
        BeanUtils.copyProperties(user, myUserDetail);
        return  myUserDetail ;
    }
}
