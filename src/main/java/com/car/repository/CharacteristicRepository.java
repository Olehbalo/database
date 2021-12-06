package com.car.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.car.domain.Characteristic;

@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer> {
}