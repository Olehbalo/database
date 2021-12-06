package com.car.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.car.domain.CarType;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Integer> {
}