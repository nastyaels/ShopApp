package ru.nastya.myapplication.ui.cake.cakeList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nastya.myapplication.App
import ru.nastya.myapplication.data.repository.CakesRepositoryNet
import ru.nastya.myapplication.ui.cake.cakeList.adapter.CakesVM

class CakeListViewModel(application: Application) : AndroidViewModel(application) {
    private val cakes: MutableLiveData<List<CakesVM>> = MutableLiveData()
    private val cakesRepositoryNet = CakesRepositoryNet()

    init{
        loadCakes()
    }

    fun getCakes():LiveData<List<CakesVM>>{
        return cakes
    }

    private fun loadCakes(){
        viewModelScope.launch {
            cakes.postValue(cakesRepositoryNet.cakeList().map { CakesVM(getApplication<App>(), it) })
        }
    }

}