package com.javaweb.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequireDTO {
    private Long id;

    @NotNull(message = "Tên đăng nhập bắt buộc ")
    private String nameUser;

    @JsonProperty("fullName")
    private String fullName;

    @NotBlank(message = "Mất khẩu không thể để trống")
    private String passWord;

    @NotBlank(message = "Email thể để trống")
    private String email;

    @JsonProperty("confirmPassword")
    private String confirmPassword;

    @NotNull(message = "Role bắt buộc ")
    @JsonProperty("roleId")
    private Long roleId;
}
