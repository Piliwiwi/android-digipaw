package com.arech.digipaw.pet.list.data.source

import com.arech.digipaw.pet.list.data.local.database.entity.LocalPetCard
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pili Arancibia on 15-08-22.
 */

interface PetListLocal {
    suspend fun getPetCardList(): Flow<List<LocalPetCard>>
    suspend fun savePet(pet: LocalPetCard)
}