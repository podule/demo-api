package com.galia.demo.api.v1.services

import com.galia.demo.api.v1.models.Pizza

interface PizzaService {
    fun getListPizza(): List<Pizza>
    fun getPagingListPizza(page: Int, size: Int): List<Pizza>
}