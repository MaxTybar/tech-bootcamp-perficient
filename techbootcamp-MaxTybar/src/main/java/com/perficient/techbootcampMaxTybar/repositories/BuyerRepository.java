package com.perficient.techbootcampMaxTybar.repositories;

import com.perficient.techbootcampMaxTybar.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
    Buyer findByName(String name);
}
