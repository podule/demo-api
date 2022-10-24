package com.galia.demo.api.v1.repositories

import com.galia.demo.api.v1.models.Order
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Long> {

}