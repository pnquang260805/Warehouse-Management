package com.example.cloud.Controller;

import com.example.cloud.DTO.Requests.ProviderRequest;
import com.example.cloud.DTO.Response.ProviderResponse;
import com.example.cloud.Mapper.ProviderMapper;
import com.example.cloud.Service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderService providerService;
    private final ProviderMapper providerMapper;

    @GetMapping
    public ResponseEntity<List<ProviderResponse>> allProvider(){
        return ResponseEntity.ok(providerMapper.toResponse(providerService.allProvider()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderResponse> getProvider(@PathVariable Integer id){
        return ResponseEntity.ok(providerMapper.toResponse(providerService.providerById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderResponse> updateProvider(@PathVariable Integer id, @RequestBody ProviderRequest request){
        return ResponseEntity.ok(providerMapper.toResponse(providerService.updateProvider(id, request)));
    }

    @PostMapping
    public ResponseEntity<ProviderResponse> createProvider(@RequestBody ProviderRequest request){
        return ResponseEntity.ok(providerMapper.toResponse(providerService.createProvider(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
       providerService.deleteProvider(id);
       return ResponseEntity.ok(true);
    }
}
