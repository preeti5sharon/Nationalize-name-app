package com.example.nationalizeapp


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country(
    @Json(name = "country_id")
    val countryId: String,
    val probability: Double
)