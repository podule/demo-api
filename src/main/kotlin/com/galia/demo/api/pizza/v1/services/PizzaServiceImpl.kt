package com.galia.demo.api.pizza.v1.services

import com.galia.demo.api.pizza.v1.models.Pizza
import com.galia.demo.api.pizza.v1.repositories.PizzaRepository
import org.springframework.stereotype.Service

@Service
class PizzaServiceImpl(val repository: PizzaRepository): PizzaService {
    override fun getListPizza(): List<Pizza> {
        return  repository.findAll().toList()
    }
}