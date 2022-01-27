package com.perficient.techbootcampMaxTybar.services;

import java.util.List;

import com.perficient.techbootcampMaxTybar.entities.Buyer;
import com.perficient.techbootcampMaxTybar.repositories.BuyerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    @Autowired 
    private BuyerRepository buyerRepository;

    public Buyer saveBuyer(Buyer product) {
        return buyerRepository.save(product);
    }

    public List<Buyer> saveBuyers(List<Buyer> buyers) {
        return buyerRepository.saveAll(buyers);
    }

    public List<Buyer> getBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer getBuyerById(int id) {
        return buyerRepository.findById(id).orElse(null);
    }

    public Buyer getBuyerByName(String name) {
        return buyerRepository.findByName(name);
    }

    public Buyer updateBuyer(Buyer buyer) {
        Buyer existingProduct = buyerRepository.findById(buyer.getId()).orElse(null);
        existingProduct.setName(buyer.getName());
        
        return buyerRepository.save(existingProduct);
    }

    public String deleteBuyer(int id) {
        buyerRepository.deleteById(id);
        return "Product removed successfully (id: " + id + ").";
    }
}
