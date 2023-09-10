package com.meneses.pets.model

@JvmRecord
data class Owner(val petsIds: Set<Int>)

const val OWNER_TYPE = "Owner"
