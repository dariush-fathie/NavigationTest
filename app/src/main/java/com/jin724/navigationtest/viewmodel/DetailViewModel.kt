package com.jin724.navigationtest.viewmodel

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    val liveId = MutableLiveData(-1)

}


@BindingAdapter("detailId")
fun setDetailId(textView: AppCompatTextView, id: Int) {
    textView.text = id.toString() + " this is from binding adapter ..."
}