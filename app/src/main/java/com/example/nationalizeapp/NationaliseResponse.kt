package com.example.nationalizeapp

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NationaliseResponse(
    val count: Int,
    val country: List<Country>,
    val name: String,
)
