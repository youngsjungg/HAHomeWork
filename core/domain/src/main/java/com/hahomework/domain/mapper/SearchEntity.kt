package com.hahomework.domain.mapper

import com.hahomework.domain.entity.search.BookEntity
import com.hahomework.model.account.common.Book

fun Book.toEntity() = BookEntity(
    authors = authors,
    contents = contents,
    datetime = datetime,
    isbn = isbn,
    price = price,
    publisher = publisher,
    salePrice = salePrice,
    status = status,
    thumbnail = thumbnail,
    title = title,
    translators = translators,
    url = url,
)
