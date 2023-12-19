package com.tasty.recipesapp.services

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface RecipeService {
    @GET("recipes/list")
    @Headers(
        "X-RapidAPI-Key: 59e71827c2msh46cfab252c658e4p19ec9ejsn20947be0536b",
        "X-RapidAPI-Host: tasty.p.rapidapi.com"
    )
    suspend fun getRecipes(
        @Query("from") from: String,
        @Query("size") size: String,
        @Query("tags") tags: String? = null
    ): RecipeResponse
}