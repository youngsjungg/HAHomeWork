package com.hahomework.data.remote

import androidx.paging.PagingData
import com.hahomework.model.account.common.Book
import com.hahomework.model.account.common.BookResponse
import kotlinx.coroutines.flow.Flow

interface SearchRemoteDataSource {

    fun fetchSearchBookList(
        query: String,
        sortType: String,
    ): Flow<PagingData<Book>>
}