package com.arech.digipaw.pet.list.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Pili Arancibia on 15-08-22.
 */

@Entity
data class LocalPetCard(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "animal") val animal: String?,
    @ColumnInfo(name = "gender") val gender: String?,
    @ColumnInfo(name = "breed") val breed: String?,
    @ColumnInfo(name = "age") val age: Int?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "photo") val photo: String?,
)
