package com.example.cloud.Mapper;

import com.example.cloud.DTO.Requests.ProviderRequest;
import com.example.cloud.DTO.Response.ProviderResponse;
import com.example.cloud.Model.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProviderMapper {
    @Mapping(target = "id", ignore = true)       // bỏ qua id
    @Mapping(target = "products", ignore = true)
    Provider toModel(ProviderRequest providerRequest);
    @Mapping(target = "productsId", source = "provider", qualifiedByName = "mapProductsToIds")
    List<ProviderResponse> toResponse(List<Provider> provider);
    @Mapping(
            target = "productsId",
            expression = "java(provider.getProducts().stream().map(d -> d.getId()).collect(java.util.stream.Collectors.toList()))"
    )
    ProviderResponse toResponse(Provider provider);

    @Named("mapProductsToIds")
    default List<Integer> mapProductsToIds(Provider provider) {
        if (provider.getProducts() == null || provider.getProducts().isEmpty()) {
            return Collections.emptyList();
        }
        return provider.getProducts().stream()
                .map(product -> product.getId())
                .collect(Collectors.toList());
    }
}
