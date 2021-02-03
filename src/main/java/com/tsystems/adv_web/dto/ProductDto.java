package com.tsystems.adv_web.dto;

import javax.ejb.Singleton;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Singleton
public class ProductDto {
    private Long id;

    private String name;

    private Double price;

    private String category;

    private Double weight;

    private Double volume;

    private Integer stock;
}
