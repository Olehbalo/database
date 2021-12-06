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

@RequestMapping(value = "/customer")
@RestController
@AllArgsConstructor
public class CustomerController extends AbstractController<Customer, CustomerDto, Integer> {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Override
    protected AbstractService<Customer, Integer> getService() {
        return customerService;
    }

    @Override
    protected AbstractMapper<Customer, CustomerDto> getMapper() {
        return customerMapper;
    }
}
