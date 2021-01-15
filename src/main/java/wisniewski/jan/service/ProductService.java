package wisniewski.jan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wisniewski.jan.dtos.ProductDto;
import wisniewski.jan.mapper.Mapper;
import wisniewski.jan.models.Product;
import wisniewski.jan.repositories.ProductRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto create(ProductDto productDto){
        log.info("Enter productService -> create() with: " +productDto);
        Product product = Mapper.fromProductDtoToProduct(productDto);
        productRepository.save(product);
        return productDto;
    }
}
