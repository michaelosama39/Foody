package com.example.foody.view.home.recipesFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.foody.R
import com.example.foody.adapter.RecipesAdapter
import com.example.foody.utilts.BusinessConst
import com.example.foody.utilts.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipes.*
import java.util.*


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
        viewModel.recipesList.observe(viewLifecycleOwner , androidx.lifecycle.Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Log.e("Status" , "Success" + it.data+"")
                    adapter.setData(it.data as ArrayList<Result>)
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
            VERTICAL, false)
    }

    override fun onRecipesItemClicked(recipesModelItem: Result) {
//        val bundle = Bundle()
//        bundle.putString(BusinessConst.NEWS_DATA_ITEM, recipesModelItem.toString())
//        val fragment = DetailsFragment()
//        fragment.arguments = bundle
//        val fragmentTransaction: FragmentTransaction = getFragmentManager()!!.beginTransaction()
//        fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack(null).commit()

        val fragment = DetailsFragment()
        fragmentManager!!
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

    }
}