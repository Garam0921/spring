package dw.wholesale_company.repository;

import dw.wholesale_company.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
