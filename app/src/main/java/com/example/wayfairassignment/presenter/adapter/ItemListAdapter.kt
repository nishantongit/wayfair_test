package com.example.wayfairassignment.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.wayfairassignment.R
import com.example.wayfairassignment.data.entitiy.ProductsDto
import com.example.wayfairassignment.presenter.viewmodel.ItemViewModel

class ItemListAdapter :RecyclerView.Adapter<ItemListAdapter.RecyclerViewHolder>(){

    private var list = ArrayList<RecyclerViewItem>()

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): RecyclerViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            view,
            parent,
            false
        )
        return RecyclerViewHolder(binding)
    }


    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        bind(holder.viewBinding, getViewModel(position), position)
        holder.viewBinding.executePendingBindings()
    }


    private fun bind(
        viewDataBinding: ViewDataBinding,
        viewModel: RecyclerViewItemViewModel,
        position: Int
    ) {
        viewDataBinding.setVariable(BR.vm, viewModel)
    }


    private fun getViewModel(position: Int): ItemViewModel {
        return ItemViewModel(
            list[position].any as ProductsDto
        )
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun swapData(data: List<ProductsDto>?) {
        list.clear()
        data?.forEach {
            list.add(RecyclerViewItem("", it))
        }
        notifyDataSetChanged()
    }

    data class RecyclerViewItem(var viewType: String, var any: Any?)

    interface RecyclerViewItemViewModel

    class RecyclerViewHolder(val viewBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewBinding.root)
}