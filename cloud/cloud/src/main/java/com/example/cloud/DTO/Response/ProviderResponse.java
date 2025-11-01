package com.example.cloud.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProviderResponse {
    Integer id;
    String name;
    String location;
    String email;
    String phone;
    List<Integer> productsId;
}
