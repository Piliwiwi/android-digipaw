package com.arech.digipaw.pet.list.presentation.list.mapper

import com.arech.digipaw.pet.list.data.local.database.entity.LocalPetCard
import com.arech.digipaw.pet.list.presentation.model.Age
import com.arech.digipaw.pet.list.presentation.model.Gender
import com.arech.digipaw.pet.list.presentation.model.Gender.Female
import com.arech.digipaw.pet.list.presentation.model.Gender.Male
import com.arech.digipaw.pet.list.presentation.model.Gender.NoBinary
import com.arech.digipaw.pet.list.presentation.model.PetCard
import javax.inject.Inject

/**
 * Created by Pili Arancibia on 15-08-22.
 */

class PetCardMapper @Inject constructor() {
    fun LocalPetCard.toPresentation() = PetCard(
        id = id,
        name = name.orEmpty(),
        description = description.orEmpty(),
        animal = animal.orEmpty(),
        breed = breed.orEmpty(),
        photo = photo.orEmpty(),
        gender = getGender(gender.orEmpty()),
        age = getAgeText(age ?: 0)
    )

    private fun getGender(gender: String): Gender =
        when (gender) {
            Male.type -> Male
            Female.type -> Female
            else -> NoBinary
        }

    private fun getAgeText(age: Int): Age =
        Age(
            value = age,
            description = if (age == 1) "$age año"
            else if (age <= 0) "Menos de 1 año"
            else "$age años"
        )
}