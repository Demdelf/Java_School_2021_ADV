package com.tsystems.adv_web.rest;

import com.tsystems.adv_web.dto.ProductDto;
import com.tsystems.adv_web.dto.ProductsDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ejb.Singleton;

@Singleton
@ManagedBean(name = "productsGetter")
@SessionScoped
public class ProductsGetter implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    ProductsDto productsDto;

    public List<ProductDto> getProducts() {
        return products;
    }

    private List<ProductDto> products;

    private static final String REST_URI
            = "http://localhost:8080/client";

    private Client client = ClientBuilder.newClient();
    public ProductsDto getBestProducts(){
        products = new ArrayList<>();
        productsDto = client.target(REST_URI).path("")
                .request(MediaType.APPLICATION_JSON).get(ProductsDto.class);
        setProductsDto(productsDto);
        products.addAll(productsDto.getProducts());
        return productsDto;
    }

    public ProductsDto getProductsDto() {
        return productsDto;
    }

    public void setProductsDto(ProductsDto productsDto) {
        this.productsDto = productsDto;
    }
}
