package wisniewski.jan.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wisniewski.jan.dtos.ProductDto;
import wisniewski.jan.service.ProductService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/product")
public class ProductResource {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> findAll() {
        return new ResponseEntity<List<ProductDto>>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        log.info("Enter productService -> create() with: " + productDto);
        return new ResponseEntity<ProductDto>(productService.create(productDto), HttpStatus.OK);
    }

}
