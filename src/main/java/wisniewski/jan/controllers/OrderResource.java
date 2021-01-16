package wisniewski.jan.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wisniewski.jan.dtos.BillDto;
import wisniewski.jan.dtos.OrderDto;
import wisniewski.jan.service.BillService;
import wisniewski.jan.service.OrderService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderResource {

    private final OrderService orderService;
    private final BillService billService;

    @PostMapping("/create")
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {
        log.info("Enter orderController -> create() with: " + orderDto);
        return new ResponseEntity<OrderDto>(orderService.add(orderDto), HttpStatus.OK);
    }

    @PostMapping("/{id}/calculate")
    public ResponseEntity<BillDto> calculate(@PathVariable Long id, @RequestBody BillDto billDto) {
        log.info("Enter orderController -> calculate() with: " + id.toString());
        return new ResponseEntity<BillDto>(billService.create(id,billDto), HttpStatus.OK);
    }
}
