package com.hahomework.home.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Stable
sealed interface HomeUiState{

    @Immutable
    data object Loading : HomeUiState
    @Immutable
    data object Empty : HomeUiState

//    @Immutable
//    data class Books(
//        val books: List<Book>,
//    ) : MainUiState {
//
//
//    }
}
