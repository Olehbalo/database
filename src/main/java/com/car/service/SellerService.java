package com.car.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.car.domain.Seller;
import com.car.repository.SellerRepository;
import com.car.service.AbstractService;

@AllArgsConstructor
@Service
public class SellerService extends AbstractService<Seller, Integer> {
    private final SellerRepository sellerRepository;

    @Override
    protected JpaRepository<Seller, Integer> getRepository() {
        return sellerRepository;
    }
}
