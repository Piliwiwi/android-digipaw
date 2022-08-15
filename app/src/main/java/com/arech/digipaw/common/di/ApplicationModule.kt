package com.arech.digipaw.common.di

import android.content.Context
import com.arech.digipaw.common.factory.NetworkDependenciesFactory
import com.arech.mvi.execution.AppExecutionThread
import com.arech.mvi.execution.ExecutionThread
import com.arech.network.config.NetworkDependencies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun providesNetWorkDependencies(
        @ApplicationContext context: Context,
    ): NetworkDependencies =
        NetworkDependenciesFactory.makeNetworkDependencies(context)

    @Provides
    fun providesExecutionThread(): ExecutionThread = AppExecutionThread()
}