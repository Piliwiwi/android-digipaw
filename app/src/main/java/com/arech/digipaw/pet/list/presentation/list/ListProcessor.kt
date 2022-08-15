package com.arech.digipaw.pet.list.presentation.list

import com.arech.digipaw.pet.list.data.PetListDataRepository
import com.arech.digipaw.pet.list.presentation.list.ListAction.LoadPetCardListAction
import com.arech.digipaw.pet.list.presentation.list.ListResult.LoadPetCardListResult.Error
import com.arech.digipaw.pet.list.presentation.list.ListResult.LoadPetCardListResult.InProgress
import com.arech.digipaw.pet.list.presentation.list.ListResult.LoadPetCardListResult.Success
import com.arech.digipaw.pet.list.presentation.list.mapper.PetCardMapper
import com.arech.mvi.execution.ExecutionThread
import javax.inject.Inject
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

/**
 * Created by Pili Arancibia on 15-08-22.
 */

@FlowPreview
class ListProcessor @Inject constructor(
    private val repository: PetListDataRepository,
    private val mapper: PetCardMapper,
    private val executionThread: ExecutionThread
) {
    fun actionProcessor(action: ListAction): Flow<ListResult> =
        when (action) {
            LoadPetCardListAction -> loadListProcessor()
        }

    private fun loadListProcessor() = flow<ListResult> {
        repository.getAllPetCards().collect { local ->
            val pets = with(mapper) { local.toPresentation() }
            emit(Success(pets))
        }
    }.onStart {
        emit(InProgress)
    }.catch {
        emit(Error)
    }.flowOn(executionThread.ioThread())
}