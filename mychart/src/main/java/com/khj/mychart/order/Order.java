package com.khj.mychart.order;


import com.khj.mychart.member.Member;
import com.khj.mychart.order.orderitem.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",nullable = false)
    private Long orderId;

    private String orderName;

    // EAGER가 기본값
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;


    // OneToMany 는 select 두번 함
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

}
