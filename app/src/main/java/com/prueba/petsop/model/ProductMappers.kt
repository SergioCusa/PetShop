package com.prueba.petsop.model

import com.prueba.petsop.network.ProductDto

fun ProductDto.toProduct(): Product =
    Product(
        id = id,
        title = title,
        description = description,
        price = price,
        thumbnail = thumbnail,
        isFavorite = false
    )