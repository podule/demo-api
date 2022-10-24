package com.galia.demo.api.v1.components

import com.galia.demo.api.v1.helpers.OrderVO
import com.galia.demo.api.v1.helpers.OrderedPizzaVO
import com.galia.demo.api.v1.models.Order
import com.galia.demo.api.v1.models.OrderedPizza
import org.springframework.stereotype.Component

@Component
class OrderAssembler(val pizzaAssembler: PizzaAssembler) {

    fun toOrderVO(order: Order): OrderVO {
        val orderedPizza: ArrayList<OrderedPizzaVO> = ArrayList()

        order.orderedPizzaList?.mapTo(orderedPizza) {
            toOrderedPizzaVO(it)
        }

        return OrderVO(
            id = order.id,
            orderedPizzaList = orderedPizza,
            isDelivery = order.isDelivered,
            isPaid = order.isPaid
        )
    }


    fun toOrderedPizzaVO(orderedPizza: OrderedPizza): OrderedPizzaVO {
        return OrderedPizzaVO(
            id = orderedPizza.id,
            pizzaVO = pizzaAssembler.toPizzaVO(orderedPizza.pizza),
            isActive = orderedPizza.isActive,
            count = orderedPizza.count
        )
    }
}