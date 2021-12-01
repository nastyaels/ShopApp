package ru.nastya.myapplication.ui.cake.cakeInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import ru.nastya.myapplication.R
import ru.nastya.myapplication.databinding.CakeInfoFragmentBinding

class CakeInfoFragment : Fragment() {

    private lateinit var binding: CakeInfoFragmentBinding
    private val cakeInfoViewModel: CakeInfoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CakeInfoFragmentBinding.inflate(inflater,container,false)
        binding.apply {
            viewModel = cakeInfoViewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getLong("ARG_CAKE_ID")
        id?.let{
            cakeInfoViewModel.loadData(it)
        }
    }
}