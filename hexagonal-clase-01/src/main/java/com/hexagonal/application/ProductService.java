package com.hexagonal.application;

import com.hexagonal.domain.ProductServiceUserCase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductService implements ProductServiceUserCase {
    public String getProducts() {
        return "Listado de productos";
    }
}
