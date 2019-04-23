package com.jin724.navigationtest.data.subGroup

import androidx.paging.PageKeyedDataSource
import com.jin724.navigationtest.model.SubGroup
import java.util.*

class SubGroupFakeDataSource : PageKeyedDataSource<Int, SubGroup>() {

    private var page = 0

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, SubGroup>) {
        callback.onResult(generateFakeSubGroup(), null, ++page)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, SubGroup>) {
        callback.onResult(generateFakeSubGroup(), ++page)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, SubGroup>) {

    }

    private fun generateFakeSubGroup(): List<SubGroup> {
        return List(10) { index ->
            SubGroup(index + (10 * page), "${index + (10 * page)} ${UUID.randomUUID().toString().substring(0, 5)}")
        }
    }

}