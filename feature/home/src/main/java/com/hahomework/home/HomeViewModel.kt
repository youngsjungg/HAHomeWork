package com.hahomework.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

    private val _errorFlow = MutableSharedFlow<Throwable>()
    val errorFlow: SharedFlow<Throwable> get() = _errorFlow

//    val sponsorsUiState: StateFlow<SponsorsUiState> = flow { emit(getSponsorsUseCase()) }
//        .map { sponsors ->
//            if (sponsors.isNotEmpty()) {
//                SponsorsUiState.Sponsors(sponsors)
//            } else {
//                SponsorsUiState.Empty
//            }
//        }
//        .catch { throwable ->
//            _errorFlow.emit(throwable)
//        }
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = SponsorsUiState.Loading,
//        )
}
