package com.car.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.car.domain.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {
}