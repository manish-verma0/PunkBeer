package com.manish.punkbeer.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.manish.punkbeer.R
import com.manish.punkbeer.core.utils.BeerClickCallback
import com.manish.punkbeer.core.utils.Constants
import com.manish.punkbeer.core.utils.Resource
import com.manish.punkbeer.data.model.Beer
import com.manish.punkbeer.databinding.FragmentBeerListingBinding
import com.manish.punkbeer.view.adapter.BeerAdapter
import com.manish.punkbeer.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeerListingFragment : Fragment(), BeerClickCallback {

    private val mainViewModel by viewModels<MainViewModel>()
    private var adapter :BeerAdapter? = null
    lateinit var binding: FragmentBeerListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBeerListingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BeerAdapter(this)
        fetchData()
    }

    private fun fetchData() {

        binding.apply {
            beerRecycler.apply {
                adapter = this@BeerListingFragment.adapter
                layoutManager = LinearLayoutManager(context)
            }

            activity?.let {
                mainViewModel.beerList.observe(it) { result ->
                    adapter?.submitList(result.data)

                    progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                    textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                    textViewError.text = result.error?.localizedMessage
                }
            }
        }
    }

    override fun beerClick(beer: Beer) {
        val bundle = bundleOf()
        bundle.putParcelable(Constants.BEER_DATA,beer)
        findNavController().navigate(R.id.action_beerListingFragment_to_beerDetailsFragment,bundle)
    }

}