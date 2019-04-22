package com.jin724.navigationtest.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jin724.navigationtest.databinding.ItemTestBinding
import com.jin724.navigationtest.fragments.TestFragmentDirections
import com.jin724.navigationtest.viewmodel.TestViewModel
import timber.log.Timber

class TestAdapter : BaseAdapter<TestModel>({ newItem, oldItem ->
    newItem.id == oldItem.id
}) {


    init {
        Timber.e("TestAdapter created")
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TestItemHolder(ItemTestBinding.inflate(getInflater(parent), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as TestItemHolder
        getItem(position)?.let {
            with(holder) {
                bind(it, createClickListener { view ->
                    val action = TestFragmentDirections.actionTestFragmentToDetailFragment(it.id)
                    view.findNavController().navigate(action)
                })
            }
        }

    }


    inner class TestItemHolder(private val binding: ItemTestBinding) :
        BaseViewHolder<ItemTestBinding, TestModel>(binding) {

        override fun bind(item: TestModel, listener: View.OnClickListener) {
            binding.testModel = TestViewModel(item)
            with(binding) {
                clickListener = listener
                executePendingBindings()
            }
        }
    }
}


abstract class BaseAdapter<T : IModel>(private val diff: (newItem: T, oldItem: T) -> Boolean) :
    ListAdapter<T, RecyclerView.ViewHolder>(BaseDiffUtil<T>(diff)) {


    fun getInflater(parent: ViewGroup): LayoutInflater {
        return LayoutInflater.from(parent.context)
    }

    fun createClickListener(
        body: (view: View) -> Unit
    ): View.OnClickListener {
        return View.OnClickListener {
            body.invoke(it)
        }
    }

}

private class BaseDiffUtil<T : IModel>(private val diff: (newItem: T, oldItem: T) -> Boolean) :
    DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return diff.invoke(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return diff.invoke(oldItem, newItem)
    }

}


abstract class BaseViewHolder<T : ViewDataBinding, H : IModel>(binding: T) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: H, clickListener: View.OnClickListener)

}

class TestModel : IModel {
    var name: String = "default"
    var id: Int = -1
}

interface IModel
