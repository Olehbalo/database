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
public class CarDealershipController extends AbstractController<CarDealershipController, CarDealershipDto, Integer> {
    private final CarDealershipService carDealershipService;
    private final CarDealershipMapper carDealershipMapper;

    @Override
    protected AbstractService<CarDealershipController, Integer> getService() { return carDealershipService;
    }

    @Override
    protected AbstractMapper<CarDealershipController, CarDealershipDto> getMapper() { return carDealershipService;
    }
}
