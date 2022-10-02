package com.arech.digipaw.pet.list.data.source

import com.arech.digipaw.pet.list.data.local.database.entity.LocalPetCard
import kotlinx.coroutines.flow.Flow

interface PetListLocal {
    suspend fun getPetCardList(): Flow<List<LocalPetCard>>
    suspend fun savePet(pet: LocalPetCard)
}