package com.tasty.recipesapp.ui.recipe

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.tasty.recipesapp.R
import com.tasty.recipesapp.database.daos.RecipeDao
import com.tasty.recipesapp.database.dataBases.RecipeDatabase
import com.tasty.recipesapp.database.entities.RecipeEntity
import com.tasty.recipesapp.databinding.FragmentNewRecipeBinding
import com.tasty.recipesapp.providers.RepositoryProvider
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class NewRecipeFragment : Fragment() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var editTextPictureUrl: EditText
    private lateinit var editTextVideoUrl: EditText
    private lateinit var ingredientsContainer: LinearLayout
    private lateinit var instructionsContainer: LinearLayout

    private var numberOfInstructions = 0;
    private var numberOfIngredients = 0;

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_recipe, container, false)
        editTextTitle = view.findViewById(R.id.editTextTitle)
        editTextDescription = view.findViewById(R.id.editTextDescription)
        editTextPictureUrl = view.findViewById(R.id.editTextPictureUrl)
        editTextVideoUrl = view.findViewById(R.id.editTextVideoUrl)
        ingredientsContainer = view.findViewById(R.id.ingredientsContainer)
        instructionsContainer = view.findViewById(R.id.instructionsContainer)

        val btnAddIngredient: Button = view.findViewById(R.id.addIngredientButton)

        btnAddIngredient.setOnClickListener {
            addNewField(ingredientsContainer, "Ingredient")
        }

        val btnAddInstruction: Button = view.findViewById(R.id.addInstructionButton)
        btnAddInstruction.setOnClickListener {
            addNewField(instructionsContainer, "Instruction")
        }

        val btnSave: Button = view.findViewById(R.id.saveNewRecipeButton)
        btnSave.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                if(saveRecipe(view)) {
                    findNavController().navigateUp()
                    Toast.makeText(requireContext(), "Your Recipe Was Saved!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        val exitButton: Button = view.findViewById(R.id.exitButton)
        exitButton.setOnClickListener {
            findNavController().navigateUp()
        }

        return view
    }

    private fun addNewField(container: LinearLayout, hint: String) {
        val editText = EditText(requireContext())
        editText.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        if(container == ingredientsContainer){
            editText.hint =  "#" +(numberOfIngredients + 1).toString() + "."+ hint;
            numberOfIngredients++
        } else {
            editText.hint =  "#" +(numberOfInstructions + 1).toString() + "."+  hint
            numberOfInstructions++
        }

        container.addView(editText)
    }

    private fun saveRecipe(view: View) : Boolean {

        editTextTitle = view.findViewById(R.id.editTextTitle)
        editTextDescription = view.findViewById(R.id.editTextDescription)
        editTextPictureUrl = view.findViewById(R.id.editTextPictureUrl)
        editTextVideoUrl = view.findViewById(R.id.editTextVideoUrl)

        ingredientsContainer = view.findViewById(R.id.ingredientsContainer)
        instructionsContainer = view.findViewById(R.id.instructionsContainer)

        val title = editTextTitle.text.toString()
        val description = editTextDescription.text.toString()
        val pictureURL = editTextPictureUrl.text.toString()
        val videoURL = editTextVideoUrl.text.toString()


        //Validation
        if(title.isEmpty() || description.isEmpty() ) {
            Toast.makeText(requireContext(), "Please fill in at least Title and Description!", Toast.LENGTH_SHORT).show()
            return false
        }

        val ingredients = mutableListOf<String>()
        for (i in 0 until ingredientsContainer.childCount) {
            val editText = ingredientsContainer.getChildAt(i) as? EditText
            editText?.let {
                if(it.text.toString().isNotEmpty()) {
                    ingredients.add(it.text.toString())
                }
            }
        }

        val instructions = mutableListOf<String>()
        for (i in 0 until instructionsContainer.childCount) {
            val editText = instructionsContainer.getChildAt(i) as? EditText
            editText?.let {
                if(it.text.toString().isNotEmpty()) {
                    instructions.add(it.text.toString())
                }
            }
        }

        val recipe = createJsonFromInputs(title, description, pictureURL, videoURL, ingredients, instructions)
        val recipeEntity = RecipeEntity(
            json = recipe
        )

        viewLifecycleOwner.lifecycleScope.launch {

            RepositoryProvider.recipeRepository.insertRecipe(recipeEntity)
        }

        findNavController().navigateUp()
        return true
    }
    private fun createJsonFromInputs(title: String, description: String, pictureUrl: String, videoUrl: String,ingredients: List<String>, instructions: List<String>): String {

        val jsonObject = JSONObject()
        jsonObject.put("title", title)
        jsonObject.put("description", description)
        jsonObject.put("thumbnailUrl", pictureUrl)
        jsonObject.put("videoUrl", videoUrl)
        jsonObject.put("ingredients", JSONArray(ingredients))
        jsonObject.put("instructions", JSONArray(instructions))

        return jsonObject.toString()
    }

}