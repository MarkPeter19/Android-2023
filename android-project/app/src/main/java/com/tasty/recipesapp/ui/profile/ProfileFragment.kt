package com.tasty.recipesapp.ui.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tasty.recipesapp.databinding.FragmentProfileBinding
import com.tasty.recipesapp.ui.profile.ProfilePagerAdapter



class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var profileViewModel: ProfileViewModel
    //private lateinit var recipeAdapter: NewRecipeAdapter

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

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

        viewPager = binding.viewPager
        tabLayout = binding.tabLayout

        profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)

        // Create and set up the adapter
        val profilePagerAdapter = ProfilePagerAdapter(this)
        viewPager.adapter = profilePagerAdapter

        // Set up tabs
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "My Recipes"
                1 -> "Profile"
                else -> ""
            }
        }.attach()
    }


}