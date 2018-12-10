package insat.tps.tpframework.tp_framework_rest.controller;

import insat.tps.tpframework.tp_framework_dal.domain.Order;
import insat.tps.tpframework.tp_framework_dal.domain.dto.OrderDTO;
import insat.tps.tpframework.tp_framework_service.service.OrderService;
import insat.tps.tpframework.tp_framework_service.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "Orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("{id}")
    public Response addOrder(@RequestBody OrderDTO order, @PathVariable Long id) {
        return orderService.addOrder(order, id);
    }

    @GetMapping
    public Response getListOrders() {
        return orderService.getListOrders();
    }

    @GetMapping("user/{id}")
    public Response getListOrdersByUser(@PathVariable int id) {
        return orderService.getListOrdersByUser();
    }

    @GetMapping("{id}")
    public Response getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }
}
