package com.jin724.navigationtest.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jin724.navigationtest.adapter.TestAdapter
import com.jin724.navigationtest.adapter.TestModel
import com.jin724.navigationtest.databinding.FragmentTestBinding
import java.util.*


class StraightFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        val adapter = TestAdapter()
        binding.rvTest.adapter = adapter
        subscribeUI(adapter)
        return binding.root
    }


    private fun subscribeUI(adapter: TestAdapter) {
        val dataSet = Array(1000) { i ->
            val testModel = TestModel()
            testModel.id = i
            testModel.name = i.toString() + UUID.randomUUID().toString().substring(0, 6)
            testModel
        }

        adapter.submitList(dataSet.toList())

    }


}
