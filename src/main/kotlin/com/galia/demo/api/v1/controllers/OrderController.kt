package com.galia.demo.api.v1.controllers

import com.galia.demo.api.v1.components.OrderAssembler
import com.galia.demo.api.v1.helpers.OrderVO
import com.galia.demo.api.v1.services.OrderServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/v1/order")
class OrderController(val orderServiceImpl: OrderServiceImpl, val orderAssembler: OrderAssembler) {

    @GetMapping("/{orderId}")
    fun cart(@PathVariable(name = "orderId") orderId: Long, request: HttpServletRequest): ResponseEntity<OrderVO> {
        val order = orderServiceImpl.getOrder(orderId)

        return ResponseEntity.ok(orderAssembler.toOrderVO(order))
    }

    @GetMapping("/create")
    fun create(request: HttpServletRequest): ResponseEntity<OrderVO> {
        val order = orderServiceImpl.createOrder()

        return ResponseEntity.ok(orderAssembler.toOrderVO(order))
    }

    @GetMapping("/add/{orderId}/{pizzaId}")
    fun add(@PathVariable(name = "orderId") orderId: Long, @PathVariable(name = "pizzaId") pizzaId: Long, request: HttpServletRequest): ResponseEntity<Long> {
        val orderedPizza = orderServiceImpl.addPizzaOrder(pizzaId, orderId)

        return ResponseEntity.ok(orderedPizza.id)
    }

}