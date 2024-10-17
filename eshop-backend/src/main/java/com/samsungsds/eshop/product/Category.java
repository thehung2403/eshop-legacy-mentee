package com.samsungsds.eshop.product;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Category {
    @Id
    private String category;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private Set<ProductCategory> productCategories;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(Set<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getCategory() + "'" +
                ", name='" + getName() + "'" +
                ", products='" + getProductCategories() + "'" +
                "}";
    }

}