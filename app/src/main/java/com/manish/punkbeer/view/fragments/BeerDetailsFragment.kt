package com.manish.punkbeer.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.manish.punkbeer.core.utils.Constants
import com.manish.punkbeer.data.model.Beer
import com.manish.punkbeer.databinding.FragmentBeerDetailsBinding
import com.manish.punkbeer.databinding.FragmentBeerListingBinding


class BeerDetailsFragment : Fragment() {

    private lateinit var binding: FragmentBeerDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBeerDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var beer = Beer()
        if(arguments != null){
            beer = requireArguments().getParcelable(Constants.BEER_DATA)!!
        }
        setDataOnUi(beer)
    }

    private fun setDataOnUi(beer: Beer) {
        context?.let { Glide.with(it).load(beer.imageUrl).into(binding.beerImage) }
        binding.beerName.text = beer.name
        binding.beerDesc.text = beer.description
        binding.brewedDate.text = beer.firstBrewed
    }


}