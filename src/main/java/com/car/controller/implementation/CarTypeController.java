
package com.car.controller.implementation;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.car.controller.AbstractController;
import com.car.domain.drug.Country;
import com.car.dto.drug.CountryDto;
import com.car.mapper.AbstractMapper;
import com.car.mapper.drug.CountryMapper;
import com.car.service.AbstractService;
import com.car.service.drug.CountryService;

@RequestMapping(value = "/car_type")
@RestController
@AllArgsConstructor
public class CarTypeController extends AbstractController<CarType, CarTypeDto, Integer> {
    private final CarTypeService carTypeService;
    private final CarTypeMapper carTypeMapper;

    @Override
    protected AbstractService<CarType, Integer> getService() {
        return carTypeService;
    }

    @Override
    protected AbstractMapper<CarType, CarTypeDto> getMapper() {return carTypeMapper;}
}
