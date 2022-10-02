package com.arech.digipaw.pet.list.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arech.digipaw.pet.list.data.local.database.entity.LocalPetCard
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalRoomPetDao {
    @Query("SELECT * FROM localpetcard ORDER BY name")
    fun getAll(): Flow<List<LocalPetCard>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePet(pet: LocalPetCard)
}