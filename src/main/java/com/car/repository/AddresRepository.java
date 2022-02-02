package com.car.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.car.domain.Addres;

@Repository
public interface AddresRepository extends JpaRepository<Addres, Integer> {
}