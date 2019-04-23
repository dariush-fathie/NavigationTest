package com.jin724.navigationtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.jin724.navigationtest.data.subGroup.SubGroupFakeDataSourceFactory
import com.jin724.navigationtest.model.SubGroup

class SubGroupViewModel : ViewModel() {

    private val dataSourceFactory = SubGroupFakeDataSourceFactory()

    private val livePagedList: LiveData<PagedList<SubGroup>>

    init {
        livePagedList = LivePagedListBuilder<Int, SubGroup>(dataSourceFactory, createConfig()).build()
    }

    fun getLivePagedList() = livePagedList

    private fun createConfig() = PagedList.Config.Builder()
            .setPageSize(20)
            .setEnablePlaceholders(false)
            .build()

}