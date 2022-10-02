package com.arech.digipaw.pet.list.data

import com.arech.digipaw.pet.list.data.local.database.entity.LocalPetCard
import com.arech.digipaw.pet.list.data.source.PetListLocal
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PetListDataRepository @Inject constructor(
    private val local: PetListLocal
) {
    suspend fun getAllPetCards(): Flow<List<LocalPetCard>> = local.getPetCardList()
    suspend fun savePet(pet: LocalPetCard) = flow {
        local.savePet(pet)
        emit(Unit)
    }
}