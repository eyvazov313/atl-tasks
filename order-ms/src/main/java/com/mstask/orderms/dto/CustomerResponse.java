package com.mstask.orderms.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    private String fullName;

    private Integer age;

    private BigDecimal balance;
}
