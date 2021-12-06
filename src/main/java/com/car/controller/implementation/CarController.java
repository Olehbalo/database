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

@RequestMapping(value = "/car")
@RestController
@AllArgsConstructor
public class CarController extends AbstractController<Car, CarDto, Integer> {
    private final CarService carService;
    private final CarMapper carMapper;

    @Override
    protected AbstractService<Car, Integer> getService() {
        return carService;
    }

    @Override
    protected AbstractMapper<Car, CarDto> getMapper() {
        return carMapper;
    }
}
