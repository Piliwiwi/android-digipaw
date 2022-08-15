package com.arech.digipaw.pet.list.ui.di

import com.arech.digipaw.pet.list.data.local.PetListLocalImpl
import com.arech.digipaw.pet.list.data.source.PetListLocal
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Pili Arancibia on 15-08-22.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalModule {
    @Binds
    abstract fun bindLocal(local: PetListLocalImpl): PetListLocal
}