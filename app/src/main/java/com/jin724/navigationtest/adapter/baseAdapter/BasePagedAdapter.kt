package com.jin724.navigationtest.adapter.baseAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jin724.navigationtest.adapter.IModel


abstract class BasePagedAdapter<T : IModel, B : ViewDataBinding>(
        _areItemsIdTheSame: (T, T) -> Boolean
        , private val _areContentTheSame: (T, T) -> Boolean)
    : PagedListAdapter<T, RecyclerView.ViewHolder>(MyDiffUtil<T>(_areItemsIdTheSame, _areContentTheSame)) {

    private class MyDiffUtil<DU : IModel>(private val areIdSame: (DU, DU) -> Boolean, private val areSame: (DU, DU) -> Boolean) : DiffUtil.ItemCallback<DU>() {

        override fun areItemsTheSame(oldItem: DU, newItem: DU): Boolean {
            return areSame.invoke(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: DU, newItem: DU): Boolean {
            return areSame.invoke(oldItem, newItem)
        }
    }


    protected abstract fun getViewBinding(parent: ViewGroup, viewType: Int): B

    protected abstract fun bindItem(itemViewBiding: B, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BaseViewHolder<T>(getViewBinding(parent, viewType))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        @Suppress("UNCHECKED_CAST")
        holder as BaseViewHolder<*>
        holder.bind()
    }


    protected fun getInflater(parent: ViewGroup): LayoutInflater {
        return LayoutInflater.from(parent.context)
    }

    protected fun createClickListener(
            body: (view: View) -> Unit
    ): View.OnClickListener {
        return View.OnClickListener {
            body.invoke(it)
        }
    }


    private inner class BaseViewHolder<T : IModel>(private val itemViewBiding: B) :
            RecyclerView.ViewHolder(itemViewBiding.root) {
        fun bind() {
            with(itemViewBiding) {
                bindItem(itemViewBiding, adapterPosition)
                executePendingBindings()
            }
        }
    }

}


