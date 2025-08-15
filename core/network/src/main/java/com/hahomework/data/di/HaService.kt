package com.hahomework.data.di

import com.hahomework.model.account.common.BookResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HaService {

    @GET("search/book")
    suspend fun fetchSearchBookList(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int = 20
    ): BookResponse

}