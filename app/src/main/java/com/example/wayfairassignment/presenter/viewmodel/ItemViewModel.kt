package com.example.wayfairassignment.presenter.viewmodel

import androidx.databinding.ObservableField
import com.example.wayfairassignment.data.entitiy.ProductsDto
import com.example.wayfairassignment.presenter.adapter.ItemListAdapter

class ItemViewModel(val data: ProductsDto) : ItemListAdapter.RecyclerViewItemViewModel {
    val name = ObservableField("")
    val tagline = ObservableField("")
    val rating = ObservableField("0")
    val date = ObservableField("")

    init {

        name.set(data.name)
        tagline.set(data.tagline)
        rating.set("Rating - "+data.rating.toString()) // should show star view
        date.set("Date - "+data.date)
    }
}