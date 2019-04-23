package com.jin724.navigationtest.adapter

import android.view.ViewGroup
import androidx.navigation.findNavController
import com.jin724.navigationtest.adapter.baseAdapter.BasePagedAdapter
import com.jin724.navigationtest.databinding.ItemSubGroupBinding
import com.jin724.navigationtest.fragments.SubGroupFragmentDirections
import com.jin724.navigationtest.model.SubGroup

class SubGroupAdapter : BasePagedAdapter<SubGroup, ItemSubGroupBinding>({ oldSubGroup, newSubGroup ->
    oldSubGroup.id == newSubGroup.id
}, { oldSubGroup, newSubGroup ->
    oldSubGroup == newSubGroup
}) {


    override fun getViewBinding(parent: ViewGroup, viewType: Int): ItemSubGroupBinding {
        return ItemSubGroupBinding.inflate(getInflater(parent), parent, false)
    }

    override fun bindItem(itemViewBiding: ItemSubGroupBinding, position: Int) {
        with(itemViewBiding) {
            subGroup = getItem(position)
            root.setOnClickListener {
                val action = SubGroupFragmentDirections.actionSubGroupFragmentToDetailFragment(subGroup!!.id)
                it.findNavController().navigate(action)
            }
        }

    }
}