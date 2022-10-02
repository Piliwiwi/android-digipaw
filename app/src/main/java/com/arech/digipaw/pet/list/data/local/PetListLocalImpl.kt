package com.arech.digipaw.pet.list.data.local

import com.arech.digipaw.pet.list.data.local.database.dao.LocalRoomPetDao
import com.arech.digipaw.pet.list.data.local.database.entity.LocalPetCard
import com.arech.digipaw.pet.list.data.local.model.LocalPetCardList
import com.arech.digipaw.pet.list.data.source.PetListLocal
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class PetListLocalImpl @Inject constructor(
    private val dao: LocalRoomPetDao
) : PetListLocal {
    override suspend fun getPetCardList(): Flow<List<LocalPetCard>> = dao.getAll()
    override suspend fun savePet(pet: LocalPetCard) {
        dao.savePet(pet)
    }

}