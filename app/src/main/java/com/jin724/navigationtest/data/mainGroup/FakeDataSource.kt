package com.jin724.navigationtest.data.mainGroup

import androidx.paging.PageKeyedDataSource
import java.util.*


class FakeDataSource : PageKeyedDataSource<Int, MainModel>() {

    private var page = 0

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, MainModel>) {
        callback.onResult(generateFakeList(10), null, ++page)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MainModel>) {
        callback.onResult(generateFakeList(10), ++page)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MainModel>) {

    }

    private fun generateFakeList(size: Int): List<MainModel> {
        return List(size) { index ->
            MainModel(index + (10 * page), UUID.randomUUID().toString().substring(0, 10))
        }
    }


}

