package com.hahomework.data.respository

import androidx.paging.PagingData
import androidx.paging.map
import com.hahomework.data.remote.SearchRemoteDataSource
import com.hahomework.domain.entity.search.BookEntity
import com.hahomework.domain.mapper.toEntity
import com.hahomework.domain.repository.SearchRepository
import com.hahomework.model.account.common.BookResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource,
//    private val searchLocalDataSource: SearchLocalDataSource
): SearchRepository {
    override fun fetchBoolSearchList(
        query: String,
        sortType: String
    ): Flow<PagingData<BookEntity>> {
        return searchRemoteDataSource.fetchSearchBookList(query, sortType).map { pagingData ->
            pagingData.map { book ->
                book.toEntity()
            }
        }
    }
}