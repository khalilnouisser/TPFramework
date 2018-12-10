package insat.tps.tpframework.tp_framework_service.service;

import insat.tps.tpframework.tp_framework_dal.domain.Order;
import insat.tps.tpframework.tp_framework_dal.domain.dto.OrderDTO;
import insat.tps.tpframework.tp_framework_service.util.Response;
import insat.tps.tpframework.tp_framework_service.util.ResultState;

public interface OrderService {
    Response addOrder(OrderDTO order, Long userId);
    Response getListOrders();
    Response getListOrdersByUser();
    Response getOrderById(int id);
}
