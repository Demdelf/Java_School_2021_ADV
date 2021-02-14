package com.tsystems.adv_web.dto;

import java.util.Base64;
import javax.ejb.Singleton;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;

    private String name;

    private Double price;

    private String category;

    private Double weight;

    private Double volume;

    private Integer stock;

//    private byte[] image;
    private String stringImage;

    public byte[] getImage(){
        return Base64.getDecoder().decode(stringImage);
    }
}
