package com.meneses.walks.repository

import com.meneses.walks.model.Walk
import org.springframework.stereotype.Repository

@Repository
class WalkRepository {

    fun findById(id: Int) = walks.find { it.id == id }

    companion object {
        private val walks = listOf(
            Walk(
                id = 0,
                name = "Park",
                description = "Go to the park to meet new friends!",
                time = "20-30 min"
            ),
            Walk(
                id = 1,
                name = "Street",
                description = "Long walk to go to another place",
                time = "30 min"
            ),
            Walk(
                id = 2,
                name = "Land",
                description = "Run and run! so much fun",
                time = "20-30 min"
            ),
            Walk(
                id = 3,
                name = "None",
                description = "Rather stay in home and rest...",
                time = "0 min"
            ),
            Walk(
                id = 4,
                name = "Garden",
                description = "Beside of the home to meditate",
                time = "10 min"
            ),
            Walk(
                id = 5,
                name = "River",
                description = "Very fun trip to the river and get wet!",
                time = "40-60 min"
            )
        )
    }
}