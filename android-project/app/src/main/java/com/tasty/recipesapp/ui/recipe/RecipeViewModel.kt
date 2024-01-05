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

    val _recipesFromApi = MutableLiveData<List<RecipeApiModel>>()
    val recipesFromApi: LiveData<List<RecipeApiModel>> get() = _recipesFromApi

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

    // Function to get filtered recipes
    fun getFilteredRecipesFromApi(query: String) {
        viewModelScope.launch {
            // Assuming you have a function in your repository to get filtered recipes
            // Adjust the function accordingly based on your repository implementation
            val filteredRecipes = RepositoryProvider.recipeRepository.getFilteredRecipesFromApi(query)

            _recipesFromApi.value = filteredRecipes
            Log.d("RECIPE_API", filteredRecipes.toString())
            filteredRecipes.forEach {
                Log.d("RECIPE_API", it.toString())
            }
        }
    }


}