package com.meneses.owners.controller

import com.meneses.owners.model.Owner
import com.meneses.owners.repository.OwnerRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class OwnerController(
    private val repository: OwnerRepository
) {
    @QueryMapping
    fun owners(): Iterable<Owner> =
        repository.findAll()

    @QueryMapping
    fun owner(@Argument id: Int): Owner? =
        repository.findById(id)
}