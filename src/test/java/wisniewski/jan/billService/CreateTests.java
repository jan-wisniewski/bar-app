package wisniewski.jan.billService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import wisniewski.jan.dtos.BillDto;
import wisniewski.jan.repositories.BillRepository;
import wisniewski.jan.service.BillService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CreateTests {

    @InjectMocks
    private BillService billService;

    @Mock
    private BillRepository billRepository;

    @Test
    @DisplayName("when create bill is successful")
    public void test1(){

        var billDto = BillDto.builder().build();


    }

}
