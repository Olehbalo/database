
package com.car.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerDto {
    private Integer id;
    private String firstName;
    private String email;
    private String lastName;
    private String phoneNumber;
}
