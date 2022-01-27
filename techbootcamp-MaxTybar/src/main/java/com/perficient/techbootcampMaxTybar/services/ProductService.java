package com.perficient.techbootcampMaxTybar.services;

import java.util.List;
import java.util.Optional;

import com.perficient.techbootcampMaxTybar.entities.Buyer;
import com.perficient.techbootcampMaxTybar.entities.Product;
import com.perficient.techbootcampMaxTybar.repositories.BuyerRepository;
import com.perficient.techbootcampMaxTybar.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired 
    private BuyerRepository buyerRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("Product with the ID " + id + " was not found.");
        }
        return product;
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product removed successfully (id: " + id + ").";
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        
        return productRepository.save(existingProduct);
    }

    public Product connectProductToBuyer(int productId, int buyerId) {
        
        Product retrievedProduct = productRepository.findById(productId).get();
        Buyer retrievedBuyer = buyerRepository.findById(buyerId).get();
        retrievedProduct.connectBuyer(retrievedBuyer);
        
        return productRepository.save(retrievedProduct);
    }

    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                    Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort); 

        return productRepository.findAll(pageable);
    }
}
