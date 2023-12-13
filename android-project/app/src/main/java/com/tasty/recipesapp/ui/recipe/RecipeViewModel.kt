package com.tasty.recipesapp.ui.recipe

import android.content.Context
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.providers.RepositoryProvider

class RecipeViewModel : ViewModel() {

    //Function to load data from the repository
    //load data from file
    fun loadRecipesData(context: Context): List<RecipeModel>? {
        return RepositoryProvider.recipeRepository.getAll(context)
    }

}