package com.example.foody.view.home.recipesFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.foody.R
import com.example.foody.utilts.BusinessConst
import kotlinx.android.synthetic.main.fragment_details.view.*

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle : Result = arguments?.getSerializable(BusinessConst.NEWS_DATA_ITEM) as Result
        Glide.with(requireContext()).load(bundle.image).into(view.image_recipesDetiles_IV)
        view.headLine_recipesDetiles_TV.text = bundle.title

    }
}