package insat.tps.tpframework.tp_framework_service.service.implementation;

import insat.tps.tpframework.tp_framework_dal.domain.Customer;
import insat.tps.tpframework.tp_framework_dal.domain.User;
import insat.tps.tpframework.tp_framework_dal.domain.dto.OrderDTO;
import insat.tps.tpframework.tp_framework_dal.repository.BookRepository;
import insat.tps.tpframework.tp_framework_dal.repository.OrderItemRepository;
import insat.tps.tpframework.tp_framework_dal.repository.OrderRepository;
import insat.tps.tpframework.tp_framework_dal.repository.UserRepository;
import insat.tps.tpframework.tp_framework_service.service.OrderService;
import insat.tps.tpframework.tp_framework_service.util.Response;
import insat.tps.tpframework.tp_framework_service.util.ResultState;
import insat.tps.tpframework.tp_framework_dal.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    UserRepository<Customer> userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    BookRepository bookRepository;

    public Response addOrder(OrderDTO orderDTO, Long userId) {
        Order order = orderDTO.adapt(orderItemRepository, bookRepository);
        Optional<Customer> user = userRepository.findById(userId);
        if (user.isPresent()){
            order.setUser(user.get());
        }
        System.out.println(order.toString());
        orderRepository.save(order);
        return new Response(ResultState.SUCCESS, "", order);
    }

    public Response getListOrders() {
        Iterable<Order> orders = this.orderRepository.findAll();
        return new Response(ResultState.SUCCESS, "", orders);
    }

    public Response getListOrdersByUser() {
        return new Response(ResultState.SUCCESS, "", null);
    }

    public Response getOrderById(int id) {
        return new Response(ResultState.SUCCESS, "", null);
    }
}
