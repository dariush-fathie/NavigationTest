package com.jin724.navigationtest.adapter

import android.view.ViewGroup
import androidx.navigation.findNavController
import com.jin724.navigationtest.adapter.baseAdapter.BasePagedAdapter
import com.jin724.navigationtest.data.mainGroup.MainModel
import com.jin724.navigationtest.databinding.ItemMainWithBindingBinding
import com.jin724.navigationtest.fragments.MainGroupFragmentDirections

class MainPagedAdapter : BasePagedAdapter<MainModel, ItemMainWithBindingBinding>({ newItem, oldItem ->
    newItem.id == oldItem.id
}, { newItem, oldItem ->
    oldItem == newItem
}) {



    override fun getViewBinding(parent: ViewGroup, viewType: Int): ItemMainWithBindingBinding {
        return ItemMainWithBindingBinding.inflate(getInflater(parent), parent, false)
    }

    override fun bindItem(itemViewBiding: ItemMainWithBindingBinding, position: Int) {
        with(itemViewBiding) {
            model = getItem(position)
            root.setOnClickListener(createClickListener {
                val action = MainGroupFragmentDirections.actionMainGroupFragmentToSubGroupFragment(model!!.id)
                it.findNavController().navigate(action)
            })

        }
    }
}