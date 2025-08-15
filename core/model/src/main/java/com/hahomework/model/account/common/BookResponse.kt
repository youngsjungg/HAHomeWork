package com.hahomework.model.account.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    @SerialName(value = "meta")
    val meta: Meta,
    @SerialName(value = "documents")
    val books: List<Book>
)