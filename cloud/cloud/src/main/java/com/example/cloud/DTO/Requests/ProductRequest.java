package com.example.cloud.DTO.Requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    String name;
    String description;
    String sku;
    String unit;
    BigDecimal price;
    Long quantity;
    Integer providerId;
}
