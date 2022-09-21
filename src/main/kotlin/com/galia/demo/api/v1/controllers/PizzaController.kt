package com.galia.demo.api.v1.controllers

import com.galia.demo.api.v1.components.PizzaAssembler
import com.galia.demo.api.v1.helpers.PizzaListVO
import com.galia.demo.api.v1.services.PizzaServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("v1/pizza")
class PizzaController(val pizzaServiceImpl: PizzaServiceImpl, val pizzaAssembler: PizzaAssembler) {

    @GetMapping("/list")
    fun list(request: HttpServletRequest): ResponseEntity<PizzaListVO> {
        val list = pizzaServiceImpl.getListPizza()

        return ResponseEntity.ok(pizzaAssembler.toPizzaListVO(list))
    }

}