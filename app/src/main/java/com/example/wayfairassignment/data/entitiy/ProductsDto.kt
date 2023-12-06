package com.example.wayfairassignment.data.entitiy

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductsDto(
    @Json(name = "name") var name: String? = null,
    @Json(name = "tagline") var tagline: String? = null,
    @Json(name = "rating") var rating: Double? = 0.00,
    @Json(name = "date") var date: String? = null
)