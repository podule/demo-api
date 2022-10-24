package com.galia.demo.api.v1.models

import javax.persistence.*
import javax.validation.constraints.Size

/**
 * Для продакшена необходимо было бы добавить время, пользователя, функционал доставки реализовать отдельно
 * Но в учебных целях сделана ограниченная версия корзины и доставки
 */
@Entity
@Table(name = "`orders`")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    @Column(name = "is_paid")
    @Size(max = 1)
    var isPaid: Int = 0,
    @Column(name = "is_delivered")
    @Size(max = 1)
    var isDelivered: Int = 0
) {
    @OneToMany(mappedBy = "order", targetEntity = OrderedPizza::class)
    var orderedPizzaList: Collection<OrderedPizza>? = null
}