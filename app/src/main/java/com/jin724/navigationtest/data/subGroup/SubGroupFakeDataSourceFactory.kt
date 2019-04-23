package com.jin724.navigationtest.data.subGroup

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.jin724.navigationtest.model.SubGroup

class SubGroupFakeDataSourceFactory : DataSource.Factory<Int, SubGroup>() {

    val liveDataSource = MutableLiveData<SubGroupFakeDataSource>()

    override fun create(): DataSource<Int, SubGroup> {
        val dataSource = SubGroupFakeDataSource()
        liveDataSource.postValue(dataSource)

        return dataSource
    }
}