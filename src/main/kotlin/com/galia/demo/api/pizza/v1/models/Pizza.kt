package com.galia.demo.api.pizza.v1.models

import javax.persistence.*
@Entity
@Table(name = "`pizza`")
class Pizza(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    @Column(unique = true)
    var title: String,
    var description: String,
    var url: String,
    var composition: String,
    var price: Int
) {
}