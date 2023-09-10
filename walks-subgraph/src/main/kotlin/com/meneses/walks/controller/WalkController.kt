package com.meneses.walks.controller

import com.meneses.walks.model.Pet
import com.meneses.walks.model.Walk
import com.meneses.walks.repository.WalkRepository
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class WalkController(
    private val repository: WalkRepository
) {
    @SchemaMapping
    fun walks(pet: Pet): Iterable<Walk?> =
        pet.walksIds.map { repository.findById(it) }
}