package com.car.service;

import com.car.domain.CarDealership;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.car.repository.CarDealershipRepository;
import com.car.service.AbstractService;

@AllArgsConstructor
@Service
public class CarDealershipService extends AbstractService<CarDealership, Integer> {
    private final CarDealershipRepository carDealershipRepository;

    @Override
    protected JpaRepository<CarDealership, Integer> getRepository() {

        return carDealershipRepository;
    }
}
