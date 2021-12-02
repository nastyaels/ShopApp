package ru.nastya.myapplication.ui.cake.cakeInfo

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import ru.nastya.myapplication.R
import ru.nastya.myapplication.data.repository.CakesRepositoryNet
import ru.nastya.myapplication.model.CakeInfo


@BindingAdapter("app:picasso")
fun image(view: ImageView, path: String?){
    Picasso.get().load("http://192.168.0.103:8080/${path}").placeholder(R.drawable.ic_baseline_cake)
        .error(R.drawable.ic_baseline_cake)
        .into(view)
}

class CakeInfoViewModel(application: Application) : AndroidViewModel(application) {
    private var cakeInfo = CakeInfo.emptyCakeInfo()
    private val storeCakesRepositoryNet = CakesRepositoryNet()

    fun loadData(id: Long){
        viewModelScope.launch {
            cakeInfo = storeCakesRepositoryNet.cake(id)
            cakeInfo.run {
                nameObs.set(name)
                caloriesObs.set(calories.toString())
                imageObs.set(image)
                priceObs.set(price.toString())
                weightObs.set(weight.toString())
                ingredientsObs.set(ingredients)
            }
        }
    }
   val nameObs = object : ObservableField<String>() {
        override fun get(): String? {
            return cakeInfo.name
        }
    }
    val caloriesObs = object:ObservableField<String>() {
        override fun get(): String? {
            return "${cakeInfo.calories.toString()} calories"
        }
    }
    val imageObs = object:ObservableField<String>() {
        override fun get(): String? {
            return cakeInfo.image
        }
    }

    val priceObs = object:ObservableField<String>() {
        override fun get(): String? {
           return "${cakeInfo.price.toString()} $"
        }
    }
    val weightObs = object:ObservableField<String>() {
        override fun get(): String? {
            return "${cakeInfo.weight.toString()} grams"
        }
    }

    val ingredientsObs = object:ObservableField<String>() {
        override fun get(): String? {
            return "Ingredients: \n${cakeInfo.ingredients}"
        }
    }




}