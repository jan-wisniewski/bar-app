package wisniewski.jan.service;

import ch.qos.logback.core.util.PropertySetterException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wisniewski.jan.dtos.ProductDto;
import wisniewski.jan.exceptions.ProductServiceException;
import wisniewski.jan.mapper.Mapper;
import wisniewski.jan.models.Product;
import wisniewski.jan.repositories.ProductRepository;
import wisniewski.jan.validator.ProductDtoValidator;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto create(ProductDto productDto) {
        ProductDtoValidator validator = new ProductDtoValidator();
        var errors = validator.validate(productDto);
        if (!errors.isEmpty()) {
            throw new ProductServiceException("Invalid Product!, errors: " + errors
                    .entrySet()
                    .stream()
                    .map(e -> e.getKey()+ " => "+e.getValue())
                    .collect(Collectors.joining(", ")));
        }
        log.info("Enter productService -> create() with: " + productDto);
        Product product = Mapper.fromProductDtoToProduct(productDto);
        productRepository.save(product);
        productDto.setId(product.getId());
        return productDto;
    }

    public List<ProductDto> findAll() {
        return Mapper.fromProductListToProductDtoList(productRepository.findAll());
    }
}
