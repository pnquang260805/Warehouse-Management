package com.example.cloud.Controller;

import com.example.cloud.DTO.Requests.ProviderRequest;
import com.example.cloud.DTO.Response.ProviderResponse;
import com.example.cloud.Mapper.ProviderMapper;
import com.example.cloud.Service.ProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Provider", description = "Quản lý nhà cung cấp")
@RestController
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderService providerService;
    private final ProviderMapper providerMapper;

    @Operation(summary = "Lấy danh sách tất cả provider")
    @GetMapping
    public ResponseEntity<List<ProviderResponse>> allProvider(){
        return ResponseEntity.ok(providerMapper.toResponse(providerService.allProvider()));
    }

    @Operation(summary = "Lấy provider theo id")
    @GetMapping("/{id}")
    public ResponseEntity<ProviderResponse> getProvider(@PathVariable Integer id){
        return ResponseEntity.ok(providerMapper.toResponse(providerService.providerById(id)));
    }

    @Operation(summary = "Sửa provider")
    @PutMapping("/{id}")
    public ResponseEntity<ProviderResponse> updateProvider(@PathVariable Integer id, @RequestBody ProviderRequest request){
        return ResponseEntity.ok(providerMapper.toResponse(providerService.updateProvider(id, request)));
    }

    @Operation(summary = "Tạo provider")
    @PostMapping
    public ResponseEntity<ProviderResponse> createProvider(@RequestBody ProviderRequest request){
        return ResponseEntity.ok(providerMapper.toResponse(providerService.createProvider(request)));
    }

    @Operation(summary = "Xóa provider")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
       providerService.deleteProvider(id);
       return ResponseEntity.ok(true);
    }
}
