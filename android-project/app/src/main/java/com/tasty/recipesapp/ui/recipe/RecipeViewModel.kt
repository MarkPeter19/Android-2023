package com.tasty.recipesapp.ui.recipe

import android.content.Context
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.data.repositories.RecipeRepository
import com.tasty.recipesapp.data.repositories.RecipeResponseDTO

class RecipeViewModel() : ViewModel() {

    private val recipeRepository = RecipeRepository()


    fun loadRecipesFromAssets(context: Context): List<RecipeModel>? {
        return recipeRepository.loadRecipesFromAssets(context)
    }



}




