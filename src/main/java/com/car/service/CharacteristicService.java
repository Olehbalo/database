package com.car.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.car.domain.Characteristic;
import com.car.repository.CharacteristicRepository;
import com.car.service.AbstractService;

@AllArgsConstructor
@Service
public class CharacteristicService extends AbstractService<Characteristic, Integer> {
    private final CharacteristicRepository characteristicRepository;

    @Override
    protected JpaRepository<Characteristic, Integer> getRepository() {
        return characteristicRepository;
    }
}
