package com.arech.digipaw.pet.list.ui.di

import android.content.Context
import com.arech.digipaw.pet.list.data.local.database.PetListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by Pili Arancibia on 15-08-22.
 */

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DatabaseModule {
    companion object {
        @Provides
        fun providePokemonListDatabase(@ApplicationContext context: Context) = PetListDatabase.getInstance(context)

        @Provides
        fun providePokemonDao(db: PetListDatabase) = db.contactDao()
    }
}