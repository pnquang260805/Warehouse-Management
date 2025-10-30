package com.example.cloud.DTO.Requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProviderRequest {
    String name;
    String location;
    String email;
    String phone;
}
