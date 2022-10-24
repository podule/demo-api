package com.galia.demo.api.v1.repositories

import com.galia.demo.api.v1.models.OrderedPizza
import org.springframework.data.repository.CrudRepository

interface OrderedPizzaRepository : CrudRepository<OrderedPizza, Long> {

}