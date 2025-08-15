package com.hahomework.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hahomework.data.di.HaService
import com.hahomework.data.util.Constants.PAGING_SIZE
import com.hahomework.data.util.Constants.STARTING_PAGE_INDEX
import com.hahomework.model.account.common.Book
import timber.log.Timber
import java.io.IOException
import java.nio.channels.UnresolvedAddressException

class BookSearchPagingSource(
    private val haService: HaService,
    private val query: String,
    private val sort: String,
) : PagingSource<Int, Book>() {

    override fun getRefreshKey(state: PagingState<Int, Book>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Book> {
        return try {
            val pageNumber = params.key ?: STARTING_PAGE_INDEX
            val response = haService.fetchSearchBookList(query, sort, pageNumber, params.loadSize)

            val endOfPaginationReached = response.meta.isEnd
            val data = response.books
            val prevKey = if (pageNumber == STARTING_PAGE_INDEX)
                null else pageNumber - 1
            val nextKey = if (endOfPaginationReached) {
                null
            } else {
                pageNumber + (params.loadSize / PAGING_SIZE)
            }
            LoadResult.Page(
                data = data,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            Timber.e(exception)
            LoadResult.Error(exception)
        } catch (exception: UnresolvedAddressException) {
            Timber.e(exception)
            LoadResult.Error(exception)
        }
    }
}