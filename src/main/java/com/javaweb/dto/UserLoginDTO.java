package com.javaweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @JsonProperty("userName")
    @NotBlank(message = "Tên đăng nhập không thể để trống")
    private String userName;
    @NotBlank(message = "Mật khẩu không thể để trống")
    private String passWord;
}
