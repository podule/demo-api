package com.galia.demo.api.pizza.v1.repositories

import com.galia.demo.api.pizza.v1.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findByUsername(username: String): User?
    fun findByPhoneNumber(phoneNumber: String): User?
}