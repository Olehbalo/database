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

@RequestMapping(value = "/seller")
@RestController
@AllArgsConstructor
public class SellerController extends AbstractController<Seller, SellerDto, Integer> {
    private final SellerService sellerService;
    private final SellerMapper sellerMapper;

    @Override
    protected AbstractService<Seller, Integer> getService() {
        return sellerService;
    }

    @Override
    protected AbstractMapper<Seller, SellerDto> getMapper() {
        return sellerMapper;
    }
}
