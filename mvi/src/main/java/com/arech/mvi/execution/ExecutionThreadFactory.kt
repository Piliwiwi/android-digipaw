package com.arech.mvi.execution

import com.arech.mvi.execution.ExecutionThreadEnvironment.APPLICATION
import com.arech.mvi.execution.ExecutionThreadEnvironment.TESTING
import com.arech.mvi.execution.AppExecutionThread
import com.arech.mvi.execution.ExecutionThread
import com.arech.mvi.execution.ExecutionThreadEnvironment

object ExecutionThreadFactory {
    fun makeExecutionThread(environment: ExecutionThreadEnvironment): ExecutionThread =
        when (environment) {
            APPLICATION -> AppExecutionThread()
            TESTING -> AppExecutionThread()
        }
}