package com.jin724.navigationtest.viewmodel

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.jin724.navigationtest.data.mainGroup.FakeDataSourceFactory
import com.jin724.navigationtest.data.mainGroup.MainModel

class MainListViewModel() : ViewModel() {

    private var livePagedList: LiveData<PagedList<MainModel>>
    private var dataSourceFactory: FakeDataSourceFactory = FakeDataSourceFactory()

    init {
        /*  Timber.e("person id = %d , viewModel=%s", person.id, this)*/
        livePagedList = LivePagedListBuilder<Int, MainModel>(dataSourceFactory, getPagedListConfig()).build()
    }

    val name = ObservableField<String>("")

    fun getLivePagedList() = livePagedList

}


private fun getPagedListConfig(): PagedList.Config {
    return PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()
}

@BindingAdapter("name")
fun setName(textView: AppCompatTextView, name: String) {
    textView.text = name + "this is text"
}

@BindingAdapter("modelId")
fun setModelID(textView: AppCompatTextView, id: Int) {
    textView.text = id.toString()
}