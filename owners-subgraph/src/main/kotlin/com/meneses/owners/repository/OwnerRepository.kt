package com.meneses.owners.repository

import com.meneses.owners.model.Owner
import org.springframework.stereotype.Repository

@Repository
class OwnerRepository {

    fun findAll() = owners

    fun findById(id: Int) = owners.find { it.id == id }

    companion object {
        private val owners = listOf(
            Owner(
                id = 0,
                name = "Kevin",
                petsIds = setOf(0)
            ),
            Owner(
                id = 1,
                name = "Valen",
                petsIds = setOf(1,2)
            ),
            Owner(
                id = 2,
                name = "Nubia",
                petsIds = setOf(3,4)
            ),
            Owner(
                id = 3,
                name = "Jenny",
                petsIds = setOf(5)
            ),
            Owner(
                id = 4,
                name = "Santiago",
                petsIds = setOf(6,7,8,9)
            ),
        )
    }
}