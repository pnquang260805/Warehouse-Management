package com.example.cloud.Mapper;

import com.example.cloud.DTO.Requests.ProviderRequest;
import com.example.cloud.DTO.Response.ProviderResponse;
import com.example.cloud.Model.Provider;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProviderMapper {
    Provider toModel(ProviderRequest providerRequest);
    List<ProviderResponse> toResponse(List<Provider> provider);

    ProviderResponse toResponse(Provider provider);
}
