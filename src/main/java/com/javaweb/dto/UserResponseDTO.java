package com.javaweb.dto;


import com.javaweb.entity.DateOfCommon;
import com.javaweb.entity.Role;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Setter
@Getter
public class UserResponseDTO {
    private Long id;
    private String nameUser;
    private String passWord;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;
    private String status;
    private Boolean isActive;
    private Date createdDate;
    private List<Role> roleList;
}
