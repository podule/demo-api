package com.galia.demo.api.pizza.v1.services

import com.galia.demo.api.pizza.v1.models.Pizza

interface PizzaService {
    fun getListPizza(): List<Pizza>
}