package com.example.cloud.Service;

import com.example.cloud.DTO.Requests.ProductRequest;
import com.example.cloud.Mapper.ProductMapper;
import com.example.cloud.Model.Product;
import com.example.cloud.Model.Provider;
import com.example.cloud.Repository.ProductRepository;
import com.example.cloud.Repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final ProviderRepository providerRepository;

    public Product createProduct(ProductRequest request){
        Product newProduct = productMapper.toProduct(request);
        Integer providerId = request.getProviderId();
        Provider provider = providerRepository.findById(providerId).orElseThrow(()->new RuntimeException("Provider not found"));
        newProduct.setProvider(provider);
        provider.getProducts().add(newProduct);
        return productRepository.save(newProduct);
    }

    public Product getProduct(Integer id){
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
    }

    public List<Product> allProduct(){
        return productRepository.findAll();
    }

    public List<Product> getProductContainKeyword(String keyword){
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    public Product updateProduct(Integer id, ProductRequest request){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        product.setName(request.getName());
        product.setDescription(product.getDescription());
        product.setSku(request.getSku());
        product.setUnit(request.getUnit());
        product.setQuantity(request.getQuantity());
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}
