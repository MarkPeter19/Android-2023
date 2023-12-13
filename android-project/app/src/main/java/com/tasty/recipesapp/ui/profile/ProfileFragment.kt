package com.tasty.recipesapp.ui.profile


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tasty.recipesapp.data.models.NewRecipeModel
import com.tasty.recipesapp.databinding.FragmentProfileBinding
import com.tasty.recipesapp.ui.recipe.NewRecipeAdapter
import com.tasty.recipesapp.ui.recipe.NewRecipeDetailFragment
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels()
    private lateinit var recipeAdapter: NewRecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SCREENS","Profile Screen opened!")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fabAddRecipe: FloatingActionButton = binding.floatingButtonAddRecipe
        fabAddRecipe.setOnClickListener {
            profileViewModel.navigateToNewRecipeFragment(binding.root)
        }

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        recipeAdapter = NewRecipeAdapter(emptyList(),
            { recipe -> profileViewModel.confirmDeleteRecipe(recipe,requireContext(),this) },
            { recipe -> profileViewModel.onRecipeClicked(recipe, this) }
        )

        recyclerView.adapter = recipeAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            profileViewModel.getAllRecipes()
        }

        profileViewModel.allRecipes.observe(viewLifecycleOwner) { recipes ->
            recipeAdapter.updateData(recipes)
        }
    }

}