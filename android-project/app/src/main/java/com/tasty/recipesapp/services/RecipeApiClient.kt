package com.tasty.recipesapp.services

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RecipeApiClient {
    companion object {
        private const val BASE_URL = "https://tasty.p.rapidapi.com/"
    }
    private val recipeService: RecipeService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        recipeService = retrofit.create(RecipeService::class.java)
    }

    //method in order to retrieve all recipes
    suspend fun getRecipes(from: String, size: String, tags: String?):
            RecipeResponse? {
        return withContext(Dispatchers.IO) {
            try {
                Log.d("RECIPE_API", recipeService.getRecipes(from, size, tags).toString())
                recipeService.getRecipes(from, size, tags)

            } catch (e: Exception) {
                // Handle exceptions here
                null
            }
        }
    }


}