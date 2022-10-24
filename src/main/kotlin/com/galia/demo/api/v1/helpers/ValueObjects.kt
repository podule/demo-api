package com.galia.demo.api.v1.helpers

data class PizzaVO(
    var id: Long,
    var title: String,
    var description: String,
    var url: String,
    var composition: String,
    var price: Int
)

data class PizzaListVO(
    val menu: List<PizzaVO>
)

data class Discount(val img: String)

data class OrderVO(
    val id: Long,
    val orderedPizzaList: List<OrderedPizzaVO>,
    val isPaid: Int,
    val isDelivery: Int
)


data class OrderedPizzaVO(
    val id: Long,
    val pizzaVO: PizzaVO,
    val count: Int,
    val isActive: Int
)