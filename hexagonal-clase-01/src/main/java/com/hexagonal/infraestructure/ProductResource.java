package com.hexagonal.infraestructure;


import com.hexagonal.application.ProductService;
import com.hexagonal.domain.ProductServiceUserCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/products")
public class ProductResource {

    private final ProductServiceUserCase productServiceUserCase;

    @Inject
    public ProductResource(ProductService productService) {
        this.productServiceUserCase = productService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProducts() {
        return productServiceUserCase.getProducts();
    }
}