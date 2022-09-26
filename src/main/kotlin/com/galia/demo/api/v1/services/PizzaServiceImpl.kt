package com.galia.demo.api.v1.services

import com.galia.demo.api.v1.models.Pizza
import com.galia.demo.api.v1.repositories.PizzaRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class PizzaServiceImpl(val repository: PizzaRepository): PizzaService {
    override fun getListPizza(): List<Pizza> {
        return repository.findAll().toList()
    }

    override fun getPagingListPizza(page: Int, size: Int): List<Pizza> {
        val pageRequest = PageRequest.of(page, size)
        return repository.findAll(pageRequest).toList()
    }
}