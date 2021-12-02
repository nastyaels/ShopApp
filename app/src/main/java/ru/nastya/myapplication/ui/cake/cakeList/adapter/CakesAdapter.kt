package ru.nastya.myapplication.ui.cake.cakeList.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nastya.myapplication.databinding.ItemCakesVhBinding


internal class CakesAdapter : RecyclerView.Adapter<CakesVH>() {

    private var cakes = mutableListOf<CakesVM>()

    @SuppressLint("NotifyDataSetChanged")
    fun reload(newCakes: List<CakesVM>){
        cakes.clear()
        cakes.addAll(newCakes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesVH {
        val inflater = LayoutInflater.from(parent.context)
        return CakesVH(ItemCakesVhBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CakesVH, position: Int) {
        holder.bind(cakes[position])
    }

    override fun getItemCount(): Int = cakes.size
}