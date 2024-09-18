package com.taskms.customerms.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {

//    @NotBlank(message = "full name is mandatory")
    String fullName;

//    @NotNull(message = "age is mandatory")
//    @Min(value = 18, message = "minimum age is 18")
    Integer age;

//    @NotNull(message = "pin is mandatory")
//    @Min(value = 4, message = "Min character count should be 4")
    Long pin;

//    @NotNull(message = "balance is mandatory")
//    @Min(value = 0, message = "Minimum balance should be: 0")
    BigDecimal balance;
}
