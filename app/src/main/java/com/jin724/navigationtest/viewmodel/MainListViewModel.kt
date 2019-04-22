package com.jin724.navigationtest.viewmodel

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jin724.navigationtest.model.Person
import timber.log.Timber

class MainListViewModel(person: Person) : ViewModel() {

    init {
        Timber.e("person id = %d , viewModel=%s", person.id, this)
    }

    val name = ObservableField<String>(person.name)

}

@BindingAdapter("name")
fun setName(textView: AppCompatTextView, name: String) {
    textView.text = name + "this is text"
}
