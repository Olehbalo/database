package com.car.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.car.domain.CarType;
import com.car.repository.CarTypeRepository;
import com.car.service.AbstractService;

@AllArgsConstructor
@Service
public class CarTypeService extends AbstractService<CarType, Integer> {
    private final CarTypeRepository carTypeRepository;

    @Override
    protected JpaRepository<CarType, Integer> getRepository() {
        return carTypeRepository;
    }
}
