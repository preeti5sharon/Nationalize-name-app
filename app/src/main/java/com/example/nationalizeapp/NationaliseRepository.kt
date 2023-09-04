package com.example.nationalizeapp

class NationaliseRepository(private val service: NationaliseService) {
    suspend fun getNationalised(name: String) = service.getNationalised(name)
}