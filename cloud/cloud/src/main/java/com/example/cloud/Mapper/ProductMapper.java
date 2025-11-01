package com.example.cloud.Mapper;

import com.example.cloud.DTO.Requests.ProductRequest;
import com.example.cloud.DTO.Response.ProductResponse;
import com.example.cloud.Model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)       // bỏ qua id
    @Mapping(target = "provider", ignore = true)    Product toProduct(ProductRequest request);
    @Mapping(target = "providerId", expression = "java(product.getProvider().getId())")
    ProductResponse toResponse(Product product);
    List<ProductResponse> toResponse(List<Product> product);
}
