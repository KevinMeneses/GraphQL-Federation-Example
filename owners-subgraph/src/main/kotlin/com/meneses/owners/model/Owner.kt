package com.meneses.owners.model

data class Owner(
    val id: Int,
    val name: String,
    val petsIds: Set<Int>
)
