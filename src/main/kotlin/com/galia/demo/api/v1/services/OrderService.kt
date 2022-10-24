package com.galia.demo.api.v1.services

import com.galia.demo.api.v1.models.Order
import com.galia.demo.api.v1.models.OrderedPizza

interface OrderService {
    fun createOrder(): Order
    fun getOrder(id: Long): Order
    fun updateOrder(order: Order): Order
    fun addPizzaOrder(pizzaId: Long, orderId: Long): OrderedPizza
    fun updatePizzaOrder(orderedPizza: OrderedPizza): OrderedPizza
}