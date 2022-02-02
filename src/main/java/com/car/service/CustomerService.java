package com.car.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.car.domain.Customer;
import com.car.repository.CustomerRepository;
import com.car.service.AbstractService;

@AllArgsConstructor
@Service
public class CustomerService extends AbstractService<Customer, Integer> {
    private final CustomerRepository customerRepository;

    @Override
    protected JpaRepository<Customer, Integer> getRepository() {
        return customerRepository;
    }
}
