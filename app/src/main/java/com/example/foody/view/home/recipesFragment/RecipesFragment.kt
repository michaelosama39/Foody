package com.example.foody.view.home.recipesFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foody.R
import com.example.foody.adapter.RecipesAdapter
import com.example.foody.utilts.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipes.*

@AndroidEntryPoint
class RecipesFragment : Fragment() , RecipesAdapter.RecipeItemListener{

    private val viewModel: RecipesViewModel by viewModels()
    lateinit var adapter: RecipesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.recipesList.observe(viewLifecycleOwner , Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Log.e("Status" , "Success" + it.data+"")
//                    adapter.setItems(it.data as ArrayList<RecipesModelItem>?)
                }
                Resource.Status.ERROR -> {
                    Log.e("Status" , "error" + it.message +"")
                }
                Resource.Status.LOADING -> {
                    Log.e("Status" , "loading")
                }
            }
        })
    }

    private fun setupRecyclerView() {
        adapter = RecipesAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
    }

    override fun onRecipesItemClicked(recipesModelItem: RecipesModelItem) {

    }

}