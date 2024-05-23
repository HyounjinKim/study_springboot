package com.khj.mychart.order.orderitem;


import com.khj.mychart.item.Item;
import com.khj.mychart.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id",nullable = false)
    private Long orderItemId;

    private String orderItemName;
    private int orderItemPrice;
    private int orderItemQuantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item item;
}
