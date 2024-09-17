package com.lawal.ecommerce.orderline;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lawal.ecommerce.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer_order")
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer productId;

    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;



}
