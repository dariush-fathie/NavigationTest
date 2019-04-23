package com.jin724.navigationtest.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.jin724.navigationtest.adapter.MainPagedAdapter
import com.jin724.navigationtest.databinding.FragmentMainBinding
import com.jin724.navigationtest.extension.observe
import com.jin724.navigationtest.viewmodel.MainListViewModel


class MainGroupFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var mainViewModel: MainListViewModel
    lateinit var adapter: MainPagedAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = MainPagedAdapter()
        binding.rvMain.adapter = adapter

        mainViewModel = ViewModelProviders.of(this).get(MainListViewModel::class.java)

        observe(mainViewModel.getLivePagedList()) {
            adapter.submitList(it)
        }

    }

    /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
         Timber.e("onViewCreated")

         *//*val adapter = MainAdapter()*//*


        *//*adapter.submitList(
                List(10000) { i ->
                    val person = Person(i.toString(), i)
                    person
                }
        )*//*


    }*/


}
