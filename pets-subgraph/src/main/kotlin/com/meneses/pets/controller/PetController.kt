package com.meneses.pets.controller

import com.meneses.pets.model.Owner
import com.meneses.pets.model.Pet
import com.meneses.pets.repository.PetRepository
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class PetController(
    private val repository: PetRepository
) {
    @SchemaMapping
    fun pets(owner: Owner): Iterable<Pet?> =
        owner.petsIds.map { repository.findById(it) }
}