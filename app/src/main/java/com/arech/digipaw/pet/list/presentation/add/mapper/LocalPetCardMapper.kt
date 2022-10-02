package com.arech.digipaw.pet.list.presentation.add.mapper

import com.arech.digipaw.pet.list.data.local.database.entity.LocalPetCard
import com.arech.digipaw.pet.list.presentation.model.PetCard
import javax.inject.Inject

class LocalPetCardMapper @Inject constructor() {
    fun PetCard.toLocal() = LocalPetCard(
        id = id,
        name = name,
        animal = animal,
        breed = breed,
        description = description,
        photo = photo,
        gender = gender.type,
        age = age.value
    )
}