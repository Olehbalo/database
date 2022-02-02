package com.car.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.car.domain.TestDrive;
import com.car.repository.TestDriveRepository;
import com.car.service.AbstractService;

@AllArgsConstructor
@Service
public class TestDriveService extends AbstractService<TestDrive, Integer> {
    private final TestDriveRepository testDriveRepository;

    @Override
    protected JpaRepository<TestDrive, Integer> getRepository() {
        return testDriveRepository;
    }
}
