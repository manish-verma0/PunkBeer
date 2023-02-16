package com.manish.punkbeer.core.utils

import com.manish.punkbeer.data.model.Beer

interface BeerClickCallback {
    fun beerClick(beer: Beer)
}