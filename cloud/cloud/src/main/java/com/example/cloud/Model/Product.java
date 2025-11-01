package com.example.cloud.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String description;
    String sku; // Mã nội bộ
    String unit; // Đơn vị sản phẩm
    BigDecimal price;
    Long quantity;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    Provider provider;
}
