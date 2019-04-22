package com.jin724.navigationtest.viewmodel

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jin724.navigationtest.adapter.TestModel

class TestViewModel(item: TestModel) : ViewModel() {

    val name = ObservableField<String>(item.name)
}


@BindingAdapter("testName")
fun bindName(textView: AppCompatTextView, name: String) {
    textView.text = name + "x"
}