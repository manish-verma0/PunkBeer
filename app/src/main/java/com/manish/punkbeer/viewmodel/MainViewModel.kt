package com.manish.punkbeer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.manish.punkbeer.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor
    (
    repository: MainRepository,
    application: Application
) : AndroidViewModel(application) {

    val beerList = repository.getBeerList().asLiveData()
}
