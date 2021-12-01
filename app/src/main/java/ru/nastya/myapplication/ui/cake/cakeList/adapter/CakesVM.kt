package ru.nastya.myapplication.ui.cake.cakeList.adapter

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import ru.nastya.myapplication.App
import ru.nastya.myapplication.model.Cake
import ru.nastya.myapplication.ui.cake.cakeInfo.CakeInfoFragment

class CakesVM(application: Application, val cake: Cake) : AndroidViewModel(application){
    fun onClick(){
        val cakeInfoFragment = CakeInfoFragment()
        val bundle = Bundle()
        bundle.putLong("ARG_CAKE_ID", cake.id ?: 1)
        cakeInfoFragment.arguments = bundle
        getApplication<App>().mainRouter.updateMainFragment(cakeInfoFragment)
    }
}