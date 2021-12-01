package ru.nastya.myapplication.ui.cake.cakeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import ru.nastya.myapplication.databinding.CakeListFragmentBinding
import ru.nastya.myapplication.ui.cake.cakeList.adapter.CakesAdapter

class CakeListFragment : Fragment() {

    private lateinit var binding: CakeListFragmentBinding
    private val cakesAdapter = CakesAdapter()
    private val cakesListVM: CakeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CakeListFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cakeList.apply {
            adapter = cakesAdapter
            layoutManager = GridLayoutManager(context,2)
        }

        cakesListVM.getCakes().observe(viewLifecycleOwner){
            cakesAdapter.reload(it)
        }
    }


}