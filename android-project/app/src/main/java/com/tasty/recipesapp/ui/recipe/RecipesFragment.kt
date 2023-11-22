package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R
import androidx.fragment.app.viewModels
import com.tasty.recipesapp.ui.recipe.RecipeAdapter

class RecipesFragment : Fragment() {

    private val recipeViewModel: RecipeViewModel by viewModels()
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        recipeAdapter = RecipeAdapter(emptyList())

        recyclerView.adapter = recipeAdapter

        recipeViewModel.loadRecipeData(requireContext())
        recipeViewModel.recipeModels.observe(viewLifecycleOwner) { recipes ->
            for (recipeModel in recipes) {
                Log.d("Recipes", recipeModel.toString())
            }
            recipeAdapter.recipes = recipes
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }
}