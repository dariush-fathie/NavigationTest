package com.jin724.navigationtest.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jin724.navigationtest.adapter.MainAdapter
import com.jin724.navigationtest.databinding.FragmentMainBinding
import com.jin724.navigationtest.model.Person
import timber.log.Timber


class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e("onViewCreated")

        val adapter = MainAdapter()
        binding.rvMain.adapter = adapter

        adapter.submitList(
            List(10000) { i ->
                val person = Person(i.toString(), i)
                person
            }
        )

    }


}
