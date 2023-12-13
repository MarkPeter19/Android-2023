package com.tasty.recipesapp.ui.recipe

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipeDetailBinding
import kotlin.math.log

class RecipeDetailFragment : Fragment() {

    companion object {
        const val recipeTitle = "arg_recipe_title"
        const val recipeDescription = "arg_recipe_description"
        private const val SWIPE_THRESHOLD = 500
        const val ARG_RECIPE_IMAGE = "arg_recipe_image"
        const val ARG_RECIPE_INSTRUCTIONS = "arg_recipe_instructions"
        const val ARG_RECIPE_INGREDIENTS = "arg_recipe_ingredients"
        // Add other necessary arguments
    }

    private lateinit var binding: FragmentRecipeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SCREENS","Recipe Detail Screen opened")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecipeDetailBinding.inflate(inflater, container, false);
        return binding.root;
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Retrieve arguments
        val title = arguments?.getString(recipeTitle) ?: ""
        val description = arguments?.getString(recipeDescription    ) ?: ""
        val imageResId = arguments?.getString(ARG_RECIPE_IMAGE) ?: ""
        val instructions = arguments?.getString(ARG_RECIPE_INSTRUCTIONS) ?: ""
        val ingredients = arguments?.getString(ARG_RECIPE_INGREDIENTS) ?: ""
        Log.d("RECIPE_DETAIL", "onViewCreated: " + instructions)
        Log.d("RECIPE_DETAIL", "onViewCreated: " + ingredients)

        // Update UI with recipe details
        Glide.with(requireContext())
            .load(imageResId)
            .placeholder(R.drawable.recipe_icon)

            .into(binding.imageViewRecipe)

        binding.textViewInstructions.text = instructions
        binding.textViewIngredients.text = ingredients
        binding.textViewTitle.text = title
        binding.textViewDescription.text = description

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        view.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_MOVE && event.x > event.rawX + SWIPE_THRESHOLD) {
                // Swipe right detected
                activity?.onBackPressed()
                true
            } else {
                false
            }
        }

    }


}