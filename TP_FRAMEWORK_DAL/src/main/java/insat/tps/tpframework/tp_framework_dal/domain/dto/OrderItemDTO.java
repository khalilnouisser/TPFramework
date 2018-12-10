package insat.tps.tpframework.tp_framework_dal.domain.dto;

import insat.tps.tpframework.tp_framework_dal.domain.Book;
import insat.tps.tpframework.tp_framework_dal.domain.OrderItem;
import insat.tps.tpframework.tp_framework_dal.repository.BookRepository;
import lombok.Data;
import java.util.Optional;

@Data
public class OrderItemDTO {
    private Long bookId;
    private int quantity;

    public OrderItem adapt(BookRepository bookRepository) {
        OrderItem order = new OrderItem();
        System.out.println(bookRepository);
        Optional<Book> bOptional = bookRepository.findById(bookId);
        if (!bOptional.isPresent()) return null;
        Book b = bOptional.get();
        order.setBook(b);
        order.setQuantity(getQuantity());
        order.setPromotion((b.getPrice() - b.getPriceAfterPromotion()) * getQuantity());
        return order;
    }
}
