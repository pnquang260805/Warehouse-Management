package com.example.cloud.Controller;

import com.example.cloud.DTO.Requests.ProductRequest;
import com.example.cloud.DTO.Response.ProductResponse;
import com.example.cloud.Mapper.ProductMapper;
import com.example.cloud.Service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product", description = "Quản lý sản phẩm")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Operation(summary = "Tạo sản phẩm")
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request){
        return ResponseEntity.ok(productMapper.toResponse(productService.createProduct(request)));
    }

    @Operation(summary = "Tìm sản phẩm qua id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id){
        return ResponseEntity.ok(productMapper.toResponse(productService.getProduct(id)));
    }

    @Operation(summary = "Tìm các sản phảm chứa từ khóa")
    @GetMapping("/q")
    public ResponseEntity<List<ProductResponse>> productContain(@RequestParam String name){
        return ResponseEntity.ok(productMapper.toResponse(productService.getProductContainKeyword(name)));
    }

    @Operation(summary = "Tìm tất cả sản phẩm")
    @GetMapping
    public ResponseEntity<List<ProductResponse>> allProduct(){
        return ResponseEntity.ok(productMapper.toResponse(productService.allProduct()));
    }

    @Operation(summary = "Update sảm phẩm")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Integer id, @RequestBody ProductRequest request){
        return ResponseEntity.ok(productMapper.toResponse(productService.updateProduct(id, request)));
    }

    @Operation(summary = "Xóa sản phẩm")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.ok(true);
    }
}
