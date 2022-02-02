package com.car.controller.implementation;

import com.car.domain.TestDrive;
import com.car.dto.TestDriveDto;
import com.car.mapper.TestDriveMapper;
import com.car.service.TestDriveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.car.controller.AbstractController;

import com.car.mapper.AbstractMapper;

import com.car.service.AbstractService;


@RequestMapping(value = "/test_drive")
@RestController
@AllArgsConstructor
public class TestDriveController extends AbstractController<TestDrive, TestDriveDto, Integer> {
    private final TestDriveService testDriveService;
    private final TestDriveMapper testDriveMapper;

    @Override
    protected AbstractService<TestDrive, Integer> getService() {
        return testDriveService;
    }

    @Override
    protected AbstractMapper<TestDrive, TestDriveDto> getMapper() {
        return testDriveMapper;
    }
}
