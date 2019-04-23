package com.jin724.navigationtest.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.jin724.navigationtest.adapter.SubGroupAdapter
import com.jin724.navigationtest.databinding.FragmentSubGroupBinding
import com.jin724.navigationtest.extension.observe
import com.jin724.navigationtest.viewmodel.SubGroupViewModel


class SubGroupFragment : Fragment() {

    private lateinit var binding: FragmentSubGroupBinding
    private lateinit var adapter: SubGroupAdapter
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSubGroupBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = SubGroupAdapter()

        binding.rvSubGroup.adapter = adapter

        val viewModel = ViewModelProviders.of(this).get(SubGroupViewModel::class.java)
        observe(viewModel.getLivePagedList()) {
            adapter.submitList(it)
        }
    }


}
