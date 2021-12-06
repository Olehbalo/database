package com.car.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharacteristicDto {
    private Integer id;
    private String drive;
    private String color;
    private String carBody;
    private String transmission;
}
