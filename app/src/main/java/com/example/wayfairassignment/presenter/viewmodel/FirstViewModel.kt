package com.example.wayfairassignment.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wayfairassignment.data.entitiy.ProductsDto
import com.example.wayfairassignment.domain.usecase.GetProductListUseCase
import com.nishant.network.network.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val usecase: GetProductListUseCase):ViewModel() {

    //replace live data with flow and collect on UI/fragment
    //private val productListLive = MutableLiveData<List<ProductsDto>>()

    //by lazy
    private val viewState = MutableLiveData<ViewState>(ViewState.Initial)



    // don't do data manipulation  here, do this on usecase instead
    //triggering call every time on fragment configuration change
    fun getData(): MutableLiveData<ViewState> {

        viewModelScope.launch {
            viewState.postValue(ViewState.Loading("loading"))

            when(val result = usecase.getProducts()){
                is NetworkResult.Error -> {
                    //handle error
                    Log.d("result", result.code.toString()+" "+result.message)
                    viewState.postValue(ViewState.Error(result.code.toString()))
                }

                is NetworkResult.Exception -> {
                    //handle exception
                    viewState.postValue(ViewState.Error("exception"))
                }

                is NetworkResult.Success -> {
                    //handle success
                    //productListLive.postValue(result.data)
                    viewState.postValue(ViewState.Success(result.data))
                    Log.d("result", result.data.toString())
                }
            }
        }
        return viewState
    }


    //move sealed class to independent file
    sealed class ViewState{
        data object Initial : ViewState()
        class Loading(val message:String) : ViewState()
        class Success(val data: List<ProductsDto>) : ViewState()
        class Error(val message:String) : ViewState()

    }
}