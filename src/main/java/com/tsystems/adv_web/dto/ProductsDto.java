package com.tsystems.adv_web.dto;

import java.util.List;
import javax.ejb.Singleton;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Singleton
public class ProductsDto {
    private List<ProductDto> products;
}
