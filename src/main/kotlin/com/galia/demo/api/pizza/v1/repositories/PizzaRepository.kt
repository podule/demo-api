package com.galia.demo.api.pizza.v1.repositories

import com.galia.demo.api.pizza.v1.models.Pizza
import org.springframework.data.repository.CrudRepository

interface PizzaRepository : CrudRepository<Pizza, Long> {

}