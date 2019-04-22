package com.jin724.navigationtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jin724.navigationtest.R
import com.jin724.navigationtest.databinding.ItemMainBinding
import com.jin724.navigationtest.fragments.MainFragmentDirections
import com.jin724.navigationtest.model.Person
import com.jin724.navigationtest.viewmodel.MainListViewModel
import timber.log.Timber

class MainAdapter : ListAdapter<Person, RecyclerView.ViewHolder>(PersonDiffCallback()) {

    init {
        Timber.e("MainAdapter created")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PersonHolder(
            DataBindingUtil.inflate(
                getInflater(parent),
                R.layout.item_main,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as PersonHolder
        getItem(position)?.let {
            with(holder) {
                bind(createClickListener(it.id), it)
            }
        }
    }


    private fun createClickListener(id: Int): View.OnClickListener {
        return View.OnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(id)
            it.findNavController().navigate(action)
        }
    }

    // todo add this in base adapter
    fun getInflater(parent: ViewGroup): LayoutInflater {
        return LayoutInflater.from(parent.context)
    }


    class PersonHolder(private val itemBinding: ItemMainBinding) :
        RecyclerView.ViewHolder(itemBinding.root),
        IBind<Person> {

        override fun bind(clickListener: View.OnClickListener, item: Person) {
            with(itemBinding) {
                this.clickListener = clickListener
                this.viewModel = MainListViewModel(item)
                executePendingBindings()
            }
        }

    }

}


interface IBind<T> {

    fun bind(clickListener: View.OnClickListener, item: T)
}


class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {

    override fun areItemsTheSame(
        oldItem: Person,
        newItem: Person
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Person,
        newItem: Person
    ): Boolean {
        return oldItem == newItem
    }
}
