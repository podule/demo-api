package com.galia.demo.api.v1.services

import com.galia.demo.api.v1.models.Order
import com.galia.demo.api.v1.models.OrderedPizza
import com.galia.demo.api.v1.repositories.OrderRepository
import com.galia.demo.api.v1.repositories.OrderedPizzaRepository
import com.galia.demo.api.v1.repositories.PizzaRepository
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(val orderRepository: OrderRepository, val orderedPizzaRepository: OrderedPizzaRepository, val pizzaRepository: PizzaRepository) : OrderService {
    override fun createOrder(): Order {
        val order = Order()
        orderRepository.save(order)

        return order
    }

    override fun getOrder(id: Long): Order {
        return orderRepository.findById(id).get()
    }

    override fun updateOrder(order: Order): Order {
        orderRepository.save(order)

        return order
    }

    override fun addPizzaOrder(pizzaId: Long, orderId: Long): OrderedPizza {
        val order = orderRepository.findById(orderId).get()
        val pizza = pizzaRepository.findById(pizzaId).get()

        val orderedPizza  = OrderedPizza(order = order, pizza = pizza)
        orderedPizzaRepository.save(orderedPizza)

        return orderedPizza
    }

    override fun updatePizzaOrder(orderedPizza: OrderedPizza): OrderedPizza {
        orderedPizzaRepository.save(orderedPizza)

        return orderedPizza
    }
}