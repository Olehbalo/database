package com.car.service;


import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.car.domain.Addres;
import com.car.repository.AddresRepository;
import com.car.service.AbstractService;

@AllArgsConstructor
@Service
public class AddresService extends AbstractService<Addres, Integer> {
    private final AddresRepository addresRepository;

    @Override
    protected JpaRepository<Addres, Integer> getRepository() {
        return addresRepository;
    }
}
