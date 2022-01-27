package com.perficient.techbootcampMaxTybar.controllers;

import java.util.List;

import com.perficient.techbootcampMaxTybar.entities.Product;
import com.perficient.techbootcampMaxTybar.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String findAllProducts(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "products/new_product";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "products/update_product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        this.productService.deleteProduct(id);

        return "redirect:/products";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);

        return "redirect:/products";
    }

    @PutMapping("/productAndBuyer/{productId}/{buyerId}")
    public Product connectProductToBuyer(@PathVariable int productId, 
                                         @PathVariable int buyerId) {
                                         
        return productService.connectProductToBuyer(productId, buyerId);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable int pageNo,
                                @RequestParam String sortField,
                                @RequestParam String sortDirection,
                                 Model model) {
        int pageSize = 5;
        Page<Product> page = productService.findPaginated(pageNo, pageSize, sortField, sortDirection);
        List<Product> listProducts = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");

        model.addAttribute("listProducts", listProducts);
        
        return "products/index";
    }

}
