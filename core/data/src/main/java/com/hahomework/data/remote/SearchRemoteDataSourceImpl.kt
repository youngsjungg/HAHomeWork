package com.hahomework.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hahomework.model.account.common.BookResponse
import com.hahomework.data.di.HaService
import com.hahomework.data.paging.BookSearchPagingSource
import com.hahomework.data.util.Constants
import com.hahomework.model.account.common.Book
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor(
    private val haService: HaService
) : SearchRemoteDataSource {

    override fun fetchSearchBookList(
        query: String,
        sortType: String
    ): Flow<PagingData<Book>> {
        val pagingSourceFactory = { BookSearchPagingSource(haService, query, sortType) }

        return Pager(
            config = PagingConfig(
                pageSize = Constants.PAGING_SIZE,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}