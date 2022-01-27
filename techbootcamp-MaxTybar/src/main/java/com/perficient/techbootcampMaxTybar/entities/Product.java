package com.perficient.techbootcampMaxTybar.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    private String quantity;
    
    @ManyToMany
    @JoinTable(
        name = "products_bought",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "buyer_id")
    )
    private Set<Buyer> buyers = new HashSet<Buyer>();

    public void connectBuyer(Buyer buyer) {
        buyers.add(buyer);
    }
}
