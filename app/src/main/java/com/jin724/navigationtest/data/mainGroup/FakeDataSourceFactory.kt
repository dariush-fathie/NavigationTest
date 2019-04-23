package com.jin724.navigationtest.data.mainGroup

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class FakeDataSourceFactory : DataSource.Factory<Int, MainModel>() {

    val liveDataSource = MutableLiveData<FakeDataSource>()

    override fun create(): DataSource<Int, MainModel> {
        val dataSource = FakeDataSource()
        liveDataSource.postValue(dataSource)

        return dataSource
    }
}