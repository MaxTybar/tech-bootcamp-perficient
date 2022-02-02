package com.perficient.techbootcampMaxTybar.controllers;

import java.util.List;

import com.perficient.techbootcampMaxTybar.entities.Buyer;
import com.perficient.techbootcampMaxTybar.entities.Product;
import com.perficient.techbootcampMaxTybar.services.BuyerService;
import com.perficient.techbootcampMaxTybar.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuyerController {
    
    @Autowired
    private BuyerService buyerService;

    @Autowired
    private ProductService productService;

    @GetMapping("/showNewBuyerForm")
    public String showNewBuyerForm(Model model) {
        Buyer product = new Buyer();
        List<Product> listProducts = productService.getProducts();

        model.addAttribute("buyer", product);
        model.addAttribute("listProducts", listProducts);

        return "buyers/new_buyer";
    }

    @PostMapping("/saveBuyer")
    public String saveProduct(@ModelAttribute("buyer") Buyer buyer) {
        buyerService.saveBuyer(buyer);

        return "redirect:/products";
    }

}
