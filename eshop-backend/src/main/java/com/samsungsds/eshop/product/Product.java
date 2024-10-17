package com.samsungsds.eshop.product;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.samsungsds.eshop.payment.Money;

@Entity
public class Product {
    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String picture;
    @Column(nullable = false)
    private Money priceUsd;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<ProductCategory> categories;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Money getPriceUsd() {
        return this.priceUsd;
    }

    public void setPriceUsd(Money priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Set<ProductCategory> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<ProductCategory> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", picture='" + getPicture() + "'" +
                ", priceUsd='" + getPriceUsd() + "'" +
                ", categories='" + getCategories() + "'" +
                "}";
    }

}