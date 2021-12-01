package ru.nastya.myapplication.ui.cake.cakeList.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.nastya.myapplication.BR
import ru.nastya.myapplication.R
import ru.nastya.myapplication.databinding.ItemCakesVhBinding


internal class CakesVH(private val binding: ItemCakesVhBinding) : RecyclerView.ViewHolder(binding.root){
    @SuppressLint("SetTextI18n")
    fun bind(cakesVM: CakesVM){
        binding.apply {
            setVariable(BR.viewModel, cakesVM)
            cakeName.text = cakesVM.cake.name
            cakeWeight.text="${cakesVM.cake.weight.toString()} grams"
            cakeCalories.text = "${cakesVM.cake.calories.toString()} calories"
            cakePrice.text="${cakesVM.cake.price.toString()} $"
            Picasso.get()
                .load("http://192.168.0.103:8080/${cakesVM.cake.image}")
                .placeholder(R.drawable.ic_baseline_cake_24)
                .error(R.drawable.ic_baseline_cake_24)
                .into(cakeImage)
        }
    }

}