package com.car.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.car.domain.TestDrive;

@Repository
public interface TestDriveRepository extends JpaRepository<TestDrive, Integer> {
}