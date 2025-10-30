package com.example.cloud.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
}
