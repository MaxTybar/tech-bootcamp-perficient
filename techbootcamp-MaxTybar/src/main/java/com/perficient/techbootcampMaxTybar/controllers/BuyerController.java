package com.perficient.techbootcampMaxTybar.controllers;

import java.util.List;

import com.perficient.techbootcampMaxTybar.entities.Buyer;
import com.perficient.techbootcampMaxTybar.services.BuyerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuyerController {
    
    @Autowired
    private BuyerService buyerService;

    @PostMapping("/addBuyer")
    public Buyer addBuyer(@RequestBody Buyer buyer) {
        return buyerService.saveBuyer(buyer);
    }

    @PostMapping("/addBuyers")
    public List<Buyer> addBuyers(@RequestBody List<Buyer> buyers) {
        return buyerService.saveBuyers(buyers);
    }

    @GetMapping("/buyers")
    public List<Buyer> findAllBuyers() {
        return buyerService.getBuyers();
    }

    @GetMapping("/buyerById/{id}")
    public Buyer findBuyerById(@PathVariable int id) {
        return buyerService.getBuyerById(id);
    }

    @GetMapping("/buyerByName/{name}")
    public Buyer findBuyerByName(@PathVariable String name) {
        return buyerService.getBuyerByName(name);
    }

    @PutMapping("/updateBuyer")
    public Buyer updateBuyer(@RequestBody Buyer buyer) {
        return buyerService.updateBuyer(buyer);
    }

    @DeleteMapping("/deleteBuyer/{id}")
    public String deleteBuyer(@PathVariable int id) {
        return buyerService.deleteBuyer(id);
    }
}
