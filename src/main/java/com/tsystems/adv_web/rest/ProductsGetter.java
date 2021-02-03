package com.tsystems.adv_web.rest;

import com.tsystems.adv_web.dto.ProductsDto;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ejb.Singleton;

@Singleton
public class ProductsGetter {
    private static final String REST_URI
            = "http://localhost:8080/client";

    private Client client = ClientBuilder.newClient();
    public ProductsDto getBestProducts(){
        return client.target(REST_URI).path("")
                .request(MediaType.APPLICATION_JSON).get(ProductsDto.class);
    }


}
