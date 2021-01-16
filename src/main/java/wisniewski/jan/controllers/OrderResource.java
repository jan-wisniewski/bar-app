package wisniewski.jan.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wisniewski.jan.dtos.BillDto;
import wisniewski.jan.dtos.OrderDto;
import wisniewski.jan.dtos.PaymentDto;
import wisniewski.jan.service.BillService;
import wisniewski.jan.service.OrderService;
import wisniewski.jan.service.PaymentService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/order")
public class OrderResource {

    private final OrderService orderService;
    private final BillService billService;
    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {
        log.info("Enter orderResource -> create() with: " + orderDto);
        return new ResponseEntity<OrderDto>(orderService.add(orderDto), HttpStatus.OK);
    }

    @PostMapping("/{id}/bill")
    public ResponseEntity<BillDto> bill(@PathVariable Long id) {
        log.info("Enter orderResource -> calculate() with: " + id.toString());
        return new ResponseEntity<BillDto>(billService.create(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/payment")
    public ResponseEntity<PaymentDto> payment(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {
        log.info("Enter orderResource -> payment() with: " + id.toString());
        return new ResponseEntity<PaymentDto>(paymentService.create(id,paymentDto), HttpStatus.OK);
    }
}
