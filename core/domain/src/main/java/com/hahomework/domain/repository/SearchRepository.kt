package com.hahomework.domain.repository

import androidx.paging.PagingData
import com.hahomework.domain.entity.search.BookEntity
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun fetchBoolSearchList(
        query: String,
        sortType: String,
    ): Flow<PagingData<BookEntity>>
}