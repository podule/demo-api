package com.galia.demo.api.v1.models

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "`ordered_pizza`")
class OrderedPizza(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    var order: Order,
    @ManyToOne(optional = false)
    @JoinColumn(name = "pizza_id", referencedColumnName = "id")
    var pizza: Pizza,
    var count: Int = 1,
    @Column(name = "is_active")
    @Size(max = 1)
    var isActive: Int = 1
)