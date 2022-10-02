package com.arech.digipaw.pet.list.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arech.digipaw.pet.list.data.local.database.dao.LocalRoomPetDao
import com.arech.digipaw.pet.list.data.local.database.entity.LocalPetCard

@Database(entities = [LocalPetCard::class], version = 1)
abstract class PetListDatabase : RoomDatabase() {
    abstract fun contactDao(): LocalRoomPetDao

    companion object {
        @Volatile
        private var INSTANCE: PetListDatabase? = null

        fun getInstance(context: Context): PetListDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PetListDatabase::class.java, "pet-card-list-db"
            ).build()
    }
}