package com.tasty.recipesapp.services

import com.tasty.recipesapp.data.dto.RecipeDTO
import com.tasty.recipesapp.services.RecipeResponseDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RecipeDetailService {
    @GET("recipes/get-more-info")
    @Headers(
        "X-RapidAPI-Key: 59e71827c2msh46cfab252c658e4p19ec9ejsn20947be0536b",
        "X-RapidAPI-Host: tasty.p.rapidapi.com"
    )
    suspend fun getRecipeDetail(
        @Query("id") id: String
    ): RecipeDTO
}