package br.com.przucato.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.przucato.businesscard.data.BusinessCard
import br.com.przucato.businesscard.data.BusinessCardRepository

class MainViewModel(private val businessCardRepository: BusinessCardRepository): ViewModel() {

    fun getAll(): LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }

    fun insert(businessCard: BusinessCard) {
        businessCardRepository.insert(businessCard)
    }

}

class MainViewModelFactory(private val repository: BusinessCardRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class")
    }

}