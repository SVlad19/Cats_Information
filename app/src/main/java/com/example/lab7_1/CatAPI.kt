package com.example.lab7_1

import retrofit2.http.GET

interface CatAPI {
    @GET("fact")
    suspend fun getFact(): Cat
}