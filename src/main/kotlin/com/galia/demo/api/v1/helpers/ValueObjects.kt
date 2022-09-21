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
    val list: List<PizzaVO>
)