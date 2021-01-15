package wisniewski.jan.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wisniewski.jan.dtos.ProductDto;
import wisniewski.jan.service.ProductService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductResource {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto){
        log.info("Enter productService -> create() with: " +productDto);
        return new ResponseEntity<ProductDto>(productService.create(productDto), HttpStatus.OK);
    }

}
