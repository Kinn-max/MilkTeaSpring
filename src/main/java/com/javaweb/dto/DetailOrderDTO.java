package com.javaweb.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DetailOrderDTO {
    private Long id;

    private String codeDetailOrder;
    private String codeVoucher;
    private double totalPrice;
    private int quantityProduct;
    private String status;
    private String payment;
    private String note;
    private String delivery;
    private Date createdDate;
    private String createdBy;
    @NotBlank(message = "Người nhận không thể để trống")
    private String receiver;
    @NotBlank(message = "Số điện thoại người nhận thể để trống")
    private String phoneReceiver;
    @NotBlank(message = "Địa chỉ người nhận không thể để trống")
    private String addressReceiver;
    private List<OrderResponseDTO> orderResponseDTOList;

}
