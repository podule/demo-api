package com.galia.demo.api.v1.controllers

import com.galia.demo.api.v1.components.PizzaAssembler
import com.galia.demo.api.v1.helpers.PizzaListVO
import com.galia.demo.api.v1.services.PizzaServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/v1/pizza")
class PizzaController(val pizzaServiceImpl: PizzaServiceImpl, val pizzaAssembler: PizzaAssembler) {

    @Autowired
    lateinit var resourceLoader: ResourceLoader

    @GetMapping("/menu")
    fun list(request: HttpServletRequest): ResponseEntity<PizzaListVO> {
        val list = pizzaServiceImpl.getListPizza()

        return ResponseEntity.ok(pizzaAssembler.toPizzaListVO(list))
    }

    @GetMapping("/menu/{index}/{size}")
    fun list(@PathVariable(name = "index") index: Int, @PathVariable(name = "size") size: Int, request: HttpServletRequest): ResponseEntity<PizzaListVO> {
        val list = pizzaServiceImpl.getPagingListPizza(index, size)

        return ResponseEntity.ok(pizzaAssembler.toPizzaListVO(list))
    }

    @GetMapping
    @RequestMapping("/img/{title}")
    fun downloadFile(@PathVariable(name = "title") title: String, request: HttpServletRequest): ResponseEntity<Resource?>? {
        val resource: Resource = resourceLoader.getResource("classpath:img/$title")

        var contentType = request.servletContext.getMimeType(resource.file.absolutePath)

        if (contentType == null) {
            contentType = "application/octet-stream"
        }
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + resource.filename.toString() + "\""
            )
            .body<Resource?>(resource)
    }
}