package com.tsystems.adv_web.dto;

import java.util.List;
import javax.ejb.Singleton;
import javax.faces.bean.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Singleton
@NoArgsConstructor
@AllArgsConstructor
@ApplicationScoped
public class ProductsDto {
    private List<ProductDto> products;
}
