package com.hahomework.domain.usecase

import androidx.paging.PagingData
import com.hahomework.domain.entity.search.BookEntity
import com.hahomework.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchBookUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    operator fun invoke(query: String, sortType: String): Flow<PagingData<BookEntity>> {
        return searchRepository.fetchBoolSearchList(query, sortType)
    }
}