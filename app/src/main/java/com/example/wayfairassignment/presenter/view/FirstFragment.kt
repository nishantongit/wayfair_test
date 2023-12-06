package com.example.wayfairassignment.presenter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.wayfairassignment.databinding.FragmentFirstBinding
import com.example.wayfairassignment.presenter.adapter.ItemListAdapter
import com.example.wayfairassignment.presenter.viewmodel.FirstViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    private val vm: FirstViewModel by viewModels()

    //should be lateinit
    private var adapter = ItemListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        _binding?.vm = vm
        _binding?.itemsRv?.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //removed use of live data and replace to state for better testability , consider changing to flow
//        vm.getData().observe(viewLifecycleOwner){
//           // adapter.swapData(it)
//        }

        vm.getData().observe(viewLifecycleOwner){
            when(it){
                is FirstViewModel.ViewState.Error -> {
                    //show error state here
                    showSnackbar(it.message, view)
                }

                FirstViewModel.ViewState.Initial -> {
                    //show initial state
                }

                is FirstViewModel.ViewState.Loading -> {
                    showSnackbar(it.message, view)
                    //show progress bar here
                }

                is FirstViewModel.ViewState.Success -> {
                    showSnackbar("success", view)
                    adapter.swapData(it.data)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun  showSnackbar(message:String, view:View){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }
}