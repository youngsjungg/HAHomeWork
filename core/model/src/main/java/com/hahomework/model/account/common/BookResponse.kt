package com.hahomework.model.account.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    @SerialName(value = "meta") val meta: Meta,
    @SerialName(value = "documents") val documents: List<Document>
)

@Serializable
data class Meta(
    @SerialName(value = "is_end") val isEnd: Boolean,
    @SerialName(value = "pageable_count") val pageableCount: Int,
    @SerialName(value = "total_count") val totalCount: Int
)

@Serializable
data class Document(
    @SerialName(value = "authors") val authors: List<String>,
    @SerialName(value = "contents") val contents: String,
    @SerialName(value = "datetime") val datetime: String,
    @SerialName(value = "isbn") val isbn: String,
    @SerialName(value = "price") val price: Int,
    @SerialName(value = "publisher") val publisher: String,
    @SerialName(value = "sale_price") val salePrice: Int,
    @SerialName(value = "status") val status: String,
    @SerialName(value = "thumbnail") val thumbnail: String,
    @SerialName(value = "title") val title: String,
    @SerialName(value = "translators") val translators: List<String>,
    @SerialName(value = "url") val url: String
)