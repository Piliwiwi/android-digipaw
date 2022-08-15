package com.arech.digipaw.pet.list.presentation.add

import com.arech.digipaw.pet.list.data.PetListDataRepository
import com.arech.digipaw.pet.list.presentation.add.AddAction.SaveNewPetAction
import com.arech.digipaw.pet.list.presentation.add.AddResult.SaveNewPetResult.Completed
import com.arech.digipaw.pet.list.presentation.add.AddResult.SaveNewPetResult.Default
import com.arech.digipaw.pet.list.presentation.add.AddResult.SaveNewPetResult.Error
import com.arech.digipaw.pet.list.presentation.add.mapper.LocalPetCardMapper
import com.arech.digipaw.pet.list.presentation.model.PetCard
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
class AddProcessor @Inject constructor(
    private val repository: PetListDataRepository,
    private val mapper: LocalPetCardMapper,
    private val executionThread: ExecutionThread
) {
    fun actionProcessor(action: AddAction): Flow<AddResult> =
        when (action) {
            is SaveNewPetAction -> savePetProcessor(action.pet)
        }

    private fun savePetProcessor(pet: PetCard) = flow<AddResult> {
        val localPet = with(mapper) { pet.toLocal() }
        repository.savePet(localPet).collect {
            emit(Completed)
        }
    }.onStart {
        emit(Default)
    }.catch {
        emit(Error)
    }.flowOn(executionThread.ioThread())
}