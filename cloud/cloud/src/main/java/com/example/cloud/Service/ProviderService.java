package com.example.cloud.Service;

import com.example.cloud.DTO.Requests.ProviderRequest;
import com.example.cloud.Mapper.ProviderMapper;
import com.example.cloud.Model.Provider;
import com.example.cloud.Repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {
    private final ProviderMapper providerMapper;
    private final ProviderRepository providerRepository;

    public Provider createProvider(ProviderRequest request){
        Provider newProvider = providerMapper.toModel(request);
        return providerRepository.save(newProvider);
    }

    public Provider providerById(Integer id){
        return providerRepository.findById(id).orElseThrow(()->new RuntimeException("Provider not found"));
    }

    public List<Provider> allProvider(){
        return providerRepository.findAll();
    }

    public Provider updateProvider(Integer id, ProviderRequest request){
        Provider provider = providerRepository.findById(id).orElseThrow(()->new RuntimeException("Provider not found"));
        provider.setName(request.getName());
        provider.setEmail(request.getEmail());
        provider.setPhone(request.getPhone());
        provider.setLocation(request.getLocation());
        return providerRepository.save(provider);
    }

    public void deleteProvider(Integer id){
        Provider provider = providerRepository.findById(id).orElseThrow(()->new RuntimeException("Provider not found"));
        providerRepository.delete(provider);
    }
}
