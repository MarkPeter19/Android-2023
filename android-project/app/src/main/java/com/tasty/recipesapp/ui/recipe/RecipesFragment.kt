package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.RecipeModel

class RecipesFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel) {
        findNavController()
            .navigate(R.id.action_recipesFragment_to_recipeDetailFragment,
                bundleOf("recipeId" to recipe.id))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[RecipeViewModel::class.java]
        val recipes = viewModel.loadRecipesFromAssets(requireContext())


        // Create RecyclerView and set up the adapter
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val recipeAdapter = RecipeAdapter(
            recipes.orEmpty(),
            onItemClick = { recipe -> navigateToRecipeDetail(recipe) },
            onDetailsClick = { recipe -> navigateToRecipeDetail(recipe) }
        )
        recyclerView.adapter = recipeAdapter




//        Using the data write out the name and id of each recipe
        recipes?.forEach {
            Log.d("Recipe", "${it.id} ${it.name}")
            Log.d("Recipe","\t${it.description}")

            Log.d("Recipe", "Instructions:")
//            Log the instructions
            it.instructions.forEach {
                Log.d("Recipe", "\t${it.display_text}")
            }
            //Sections
            Log.d("Recipe", "Sections:")
            it.sections.forEach {
                Log.d("Recipe", "\t${it.name}")
                it.components.forEach {
                    Log.d("Recipe", "\t\t${it.raw_text}")
                }
            }
            //userRatings
            Log.d("Recipe", "User Ratings:")
            Log.d("Recipe", "\tScore: ${it.user_ratings.score}")
            Log.d("Recipe", "\tPositive: ${it.user_ratings.count_positive}")
            Log.d("Recipe", "\tNegative: ${it.user_ratings.count_negative}")
            //tags
            Log.d("Recipe", "Tags:")
            it.tags.forEach {
                Log.d("Recipe", "\t\t${it.display_name}")
            }

        }
    }
}