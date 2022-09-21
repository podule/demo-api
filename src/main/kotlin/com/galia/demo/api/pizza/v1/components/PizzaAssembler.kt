package com.galia.demo.api.pizza.v1.components

import com.galia.demo.api.pizza.v1.helpers.PizzaListVO
import com.galia.demo.api.pizza.v1.helpers.PizzaVO
import com.galia.demo.api.pizza.v1.models.Pizza
import org.springframework.stereotype.Component

@Component
class PizzaAssembler {

    fun toPizzaVO(pizza: Pizza): PizzaVO {
        return PizzaVO(pizza.id, pizza.title, pizza.description, pizza.url, pizza.composition, pizza.price)
    }

    fun toPizzaListVO(list: List<Pizza>): PizzaListVO {
        val listVO = list.map { toPizzaVO(it) }
        return PizzaListVO(listVO)
    }
}