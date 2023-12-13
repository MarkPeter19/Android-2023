package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.InstructionModel
import com.tasty.recipesapp.databinding.FragmentRecipeDetailBinding
import com.tasty.recipesapp.providers.RepositoryProvider
import kotlinx.coroutines.launch

class RecipeDetailFragment : Fragment() {

    private lateinit var binding: FragmentRecipeDetailBinding

    companion object {
        const val recipeTitle = "arg_recipe_title"
        const val recipeDescription = "arg_recipe_description"
        private const val SWIPE_THRESHOLD = 500
        const val ARG_RECIPE_IMAGE = "arg_recipe_image"
        //const val ARG_RECIPE_INSTRUCTIONS = "arg_recipe_instructions"
        const val ARG_RECIPE_INGREDIENTS = "arg_recipe_ingredients"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val args = this@RecipeDetailFragment.arguments
            val title = args?.getString(recipeTitle) ?: ""
            val description = args?.getString(recipeDescription) ?: ""
            val imageResId = args?.getString(ARG_RECIPE_IMAGE) ?: ""
           // val instructionsList = args?.getStringArrayList(ARG_RECIPE_INSTRUCTIONS)
            val ingredientsList = args?.getStringArrayList(ARG_RECIPE_INGREDIENTS)

            //Log.d("RECIPE_DETAIL", "onViewCreated: $instructionsList")
            Log.d("RECIPE_DETAIL", "onViewCreated: $ingredientsList")

            Glide.with(requireContext())
                .load(imageResId)
                .placeholder(R.drawable.recipe_icon)
                .into(binding.imageViewRecipe)

            binding.textViewTitle.text = title
            binding.textViewDescription.text = description

            // Convert the lists to string representation
            val ingredientsText = ingredientsList?.joinToString(separator = "\n") { "- $it" } ?: ""
//            val instructionsText = instructionsList?.joinToString(separator = "\n") {
//                "- ${it.displayText} (${it.time.startTime}-${it.time.endTime})"
//            } ?: ""

            binding.textViewIngredients.text = ingredientsText
            //binding.textViewInstructions.text = instructionsText
        }

        binding.backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        view.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_MOVE && event.x > event.rawX + SWIPE_THRESHOLD) {
                activity?.onBackPressed()
                true
            } else {
                false
            }
        }
    }
}
