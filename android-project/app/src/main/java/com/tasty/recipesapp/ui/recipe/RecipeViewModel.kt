package com.tasty.recipesapp.ui.recipe

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.providers.RepositoryProvider
import com.tasty.recipesapp.services.RecipeApiClient
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    //Function to load data from the repository
    //load data from file
    fun loadRecipesData(context: Context): List<RecipeModel>? {
        return RepositoryProvider.recipeRepository.getAll(context)
    }


    //load data from API
    private val recipeApiClient = RecipeApiClient()

    val _recipesFromApi = MutableLiveData<List<RecipeModel>>()
    val recipesFromApi: LiveData<List<RecipeModel>> get() = _recipesFromApi

    fun getAllRecipesFromApi() {
        viewModelScope.launch {
            val recipes = RepositoryProvider.recipeRepository.getRecipesFromApi("0", "15")

            _recipesFromApi.value = recipes
            Log.d("RECIPE_API", recipes.toString())
            recipes.forEach {
                Log.d("RECIPE_API", it.toString())
            }
        }
    }


}