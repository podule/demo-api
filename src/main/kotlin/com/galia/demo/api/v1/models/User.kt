package com.galia.demo.api.v1.models

import com.galia.demo.api.v1.listeners.UserListener
import javax.persistence.*
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Table(name = "`users`")
@EntityListeners(UserListener::class)
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    @Column(unique = true)
    @Size(min = 5)
    var username: String = "",
    @Size(min = 11)
    @Column(unique = true)
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3}) [- ]?(\\d{4})$")
    var phoneNumber: String = "",
    @Size(min = 3, max = 60)
    var password: String = "",
) {

}