package com.tasty.recipesapp.ui.profile

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment
import com.google.gson.Gson
import com.tasty.recipesapp.R
import com.tasty.recipesapp.database.entities.RecipeEntity
import com.tasty.recipesapp.data.models.NewRecipeModel
import com.tasty.recipesapp.providers.RepositoryProvider
import com.tasty.recipesapp.ui.recipe.NewRecipeDetailFragment
import kotlinx.coroutines.launch

class MyRecipesViewModel : ViewModel(){

    private val _allRecipes = MutableLiveData<List<NewRecipeModel>>()

    val allRecipes: LiveData<List<NewRecipeModel>>
        get() = _allRecipes

    suspend fun getAllRecipes(){
        viewModelScope.launch {
            val recipes = RepositoryProvider.recipeRepository.getAllOwnRecipes()
            _allRecipes.value = recipes
        }
    }

    private fun insertRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            RepositoryProvider.recipeRepository.insertRecipe(recipe)
        }
    }

    private fun removeRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            RepositoryProvider.recipeRepository.deleteRecipe(recipe)
            _allRecipes.value = RepositoryProvider.recipeRepository.getAllOwnRecipes()
        }
    }

    fun confirmDeleteRecipe(recipe: NewRecipeModel, context: Context, profileFragment: MyRecipesFragment) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.apply {
            setTitle("Delete Recipe")
            setMessage("Are you sure that you want to delete this recipe?")
            setPositiveButton("Yes") { _, _ ->
                deleteRecipe(recipe, profileViewModel = this@MyRecipesViewModel, viewLifecycleOwner = profileFragment)
            }
            setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
    private fun deleteRecipe(recipe: NewRecipeModel, profileViewModel: MyRecipesViewModel = this, viewLifecycleOwner: MyRecipesFragment) {
        val recipeEntity = convertToRecipeEntity(recipe)

        viewLifecycleOwner.lifecycleScope.launch {
            profileViewModel.removeRecipe(recipeEntity)
            profileViewModel.getAllRecipes()
        }
    }
    private fun convertToRecipeEntity(recipe: NewRecipeModel): RecipeEntity {
        val gson = Gson()
        return RecipeEntity(
            internalId = recipe.id,
            json = gson.toJson(recipe)
        )
    }

    fun onRecipeClicked(recipe: NewRecipeModel, fragment: MyRecipesFragment) {
        val bundle = Bundle()
        bundle.putLong("recipe", recipe.id)
        val detailFragment = NewRecipeDetailFragment()
        detailFragment.arguments = bundle
        NavHostFragment.findNavController(fragment).navigate(R.id.action_profileFragment_to_newRecipeDetailFragment, bundle)
    }
}