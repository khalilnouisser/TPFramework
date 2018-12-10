package insat.tps.tpframework.tp_framework_dal.domain.dto;

import insat.tps.tpframework.tp_framework_dal.domain.Order;
import insat.tps.tpframework.tp_framework_dal.domain.OrderItem;
import insat.tps.tpframework.tp_framework_dal.repository.BookRepository;
import insat.tps.tpframework.tp_framework_dal.repository.OrderItemRepository;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderDTO {
    private Double salesTaxes;
    private Double shipingFee;
    private List<OrderItemDTO> orderItems;
    public Order adapt(OrderItemRepository orderItemRepository,BookRepository bookRepository) {
        Order order = new Order();
        List<OrderItem> list = getOrderItems().stream().map(x -> x.adapt(bookRepository)).collect(Collectors.toList());
        //order.setOrderItems(list);
        order.setSalesTaxes(getSalesTaxes());
        order.setShipingFee(getShipingFee());
        //Double total = getSalesTaxes() + getShipingFee() + order.getOrderItems().stream().map(x -> x.getQuantity() * x.getBook().getPriceAfterPromotion()).mapToDouble(f -> f).sum();
        //order.setTotal(total);
        return order;
    }
}
