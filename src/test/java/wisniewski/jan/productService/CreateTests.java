package wisniewski.jan.productService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import wisniewski.jan.dtos.ProductDto;
import wisniewski.jan.mapper.Mapper;
import wisniewski.jan.models.Product;
import wisniewski.jan.repositories.ProductRepository;
import wisniewski.jan.service.ProductService;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreateTests {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("when product adding is successful, dto is returning")
    public void test1() {

        var productDto = ProductDto
                .builder()
                .name("Product")
                .price(BigDecimal.ONE)
                .build();

        var product = Mapper.fromProductDtoToProduct(productDto);

        var productWithId = Mapper.fromProductDtoToProduct(productDto);
        productWithId.setId(1L);

        Mockito
                .when(productRepository.save(product))
                .thenReturn(productWithId);

        Assertions.assertEquals(productService.create(productDto), productDto);

    }

}
