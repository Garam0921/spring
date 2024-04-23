package dw.wholesale_company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "주문세부")

public class OrderDetail {
    @Id
    @Column(name = "주문세부번호")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "주문번호")
    private Order orderId;

    @ManyToOne
    @JoinColumn(name = "제품번호")
    private Product productId;

    @Column(name = "단가")
    private long unitPrice;

    @Column(name = "주문수량")
    private long orderQuantity;

    @Column(name = "할인율")
    private float discountRate;
}