package com.meneses.pets.model

data class Pet(
    val id: Int,
    val name: String,
    val animal: String,
    val walksIds: Set<Int>
)
