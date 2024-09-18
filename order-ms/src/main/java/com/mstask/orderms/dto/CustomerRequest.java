package com.mstask.orderms.dto;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

//    @NotBlank(message = "full name can not be null, empty or just space")
    private String fullName;

    private Integer age;

    private Long pin;

    private BigDecimal balance;
}
