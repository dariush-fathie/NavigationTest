package com.jin724.navigationtest.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.jin724.navigationtest.databinding.FragmentDetailBinding
import com.jin724.navigationtest.viewmodel.DetailViewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        with(binding) {
            this.viewModel = viewModel
            lifecycleOwner = this@DetailFragment
            executePendingBindings()
        }

        arguments.let {
            val id = DetailFragmentArgs.fromBundle(it!!).itemId
            viewModel.liveId.value = id
        }

    }


}
