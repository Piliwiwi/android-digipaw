package com.arech.digipaw.pet.list.presentation.model

data class PetCard(
    val id: String,
    val name: String,
    val animal: String,
    val gender: Gender,
    val breed: String,
    val age: Age,
    val description: String,
    val photo: String,
)

data class Age(
    val value: Int,
    val description: String
)

enum class Gender(val type: String) {
    Male("male"),
    Female("female"),
    Unknown("")
}
