package com.perficient.techbootcampMaxTybar.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BUYER")
public class Buyer {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "buyers")
    private Set<Product> products = new HashSet<Product>();

}
