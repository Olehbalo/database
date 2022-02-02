package com.car.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.car.domain.Car;
import com.car.repository.CarRepository;
import com.car.service.AbstractService;

@AllArgsConstructor
@Service
public class CarService extends AbstractService<Car, Integer> {
    private final CarRepository carRepository;

    @Override
    protected JpaRepository<Car, Integer> getRepository() {
        return carRepository;
    }
}
