package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "item")
    private String item;

    @Column(name = "status")
    private String status;

    @Column(name = "orderDate")
    private @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date orderDate;

    @Column(name = "deliverDate")
    private @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date deliverDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private Customer customer;
}