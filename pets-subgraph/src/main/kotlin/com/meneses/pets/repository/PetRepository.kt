package com.meneses.pets.repository

import com.meneses.pets.model.Pet
import org.springframework.stereotype.Repository

@Repository
class PetRepository {

    fun findById(id: Int) = pets.find { it.id == id }

    companion object {
        private val pets = listOf(
            Pet(
                id = 0,
                name = "Bruno",
                animal = "Dog",
                walksIds = setOf(0, 1, 2)
            ),
            Pet(
                id = 1,
                name = "Dulce",
                animal = "Cat",
                walksIds = setOf(3)
            ),
            Pet(
                id = 2,
                name = "Toreto",
                animal = "Cat",
                walksIds = setOf(3, 4)
            ),
            Pet(
                id = 3,
                name = "Lucas",
                animal = "Dog",
                walksIds = setOf(0, 2)
            ),
            Pet(
                id = 4,
                name = "Michu",
                animal = "Cat",
                walksIds = setOf(0, 3, 4)
            ),
            Pet(
                id = 5,
                name = "Zazu",
                animal = "Dog",
                walksIds = setOf(0, 1, 5)
            ),
            Pet(
                id = 6,
                name = "Mono",
                animal = "Cat",
                walksIds = setOf(3, 4)
            ),
            Pet(
                id = 7,
                name = "Zeus",
                animal = "Cat",
                walksIds = setOf(3, 4)
            ),
            Pet(
                id = 8,
                name = "Linda",
                animal = "Cat",
                walksIds = setOf(3, 4)
            ),
            Pet(
                id = 9,
                name = "Nico",
                animal = "Dog",
                walksIds = setOf(0, 1, 2)
            )
        )
    }
}