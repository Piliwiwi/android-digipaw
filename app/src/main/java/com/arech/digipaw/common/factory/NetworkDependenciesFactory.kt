package com.arech.digipaw.common.factory

import android.content.Context
import com.arech.digipaw.BuildConfig
import com.arech.network.config.NetworkDependencies

object NetworkDependenciesFactory {
    fun makeNetworkDependencies(context: Context): NetworkDependencies =
        NetworkDependencies(
            flavorName = BuildConfig.FLAVOR,
            context = context
        )
}