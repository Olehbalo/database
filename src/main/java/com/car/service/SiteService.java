package com.car.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.car.domain.Site;
import com.car.repository.SiteRepository;
import com.car.service.AbstractService;

@AllArgsConstructor
@Service
public class SiteService extends AbstractService<Site, Integer> {
    private final SiteRepository siteRepository;

    @Override
    protected JpaRepository<Site, Integer> getRepository() {
        return siteRepository;
    }
}
