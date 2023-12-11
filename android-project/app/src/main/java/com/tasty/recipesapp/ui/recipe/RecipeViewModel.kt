package com.tasty.recipesapp.ui.recipe

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.providers.RepositoryProvider

class RecipeViewModel : ViewModel() {

    private val _recipeModels = MutableLiveData<List<RecipeModel>>()
    val recipeModels: LiveData<List<RecipeModel>> = _recipeModels

    //Function to load data from the repository
    fun loadRecipeData(context: Context) {
        val data = RepositoryProvider.recipeRepository.getAll(context)
        _recipeModels.value = data
    }

}