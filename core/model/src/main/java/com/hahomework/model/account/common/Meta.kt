package com.hahomework.model.account.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName(value = "is_end") val isEnd: Boolean,
    @SerialName(value = "pageable_count") val pageableCount: Int,
    @SerialName(value = "total_count") val totalCount: Int
)
