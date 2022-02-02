package com.car.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private Integer id;
    private String brand;
    private Integer graduathionYear ;
    private Integer serNum ;
    private String isNew ;
    private String isSold;
}
