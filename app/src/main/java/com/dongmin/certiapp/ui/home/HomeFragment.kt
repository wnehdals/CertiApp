package com.dongmin.certiapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dongmin.certiapp.CertiApplication
import com.dongmin.certiapp.R
import com.dongmin.certiapp.base.ViewBindingFragment
import com.dongmin.certiapp.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : ViewBindingFragment<FragmentHomeBinding>() {

    override val layoutId = R.layout.fragment_home
    private lateinit var certiAdapter: CertiAdapter
    private val homeViewModel: HomeViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initViewModel()
    }
    private fun initViewModel(){
        homeViewModel.getCertiList(serviceKey = CertiApplication.dataApiKey)
        //binding.circleView.setArcProportion(0.50f)
        //homeViewModel.getMastFetch()

        homeViewModel.apply {
            certiList.observe(viewLifecycleOwner, {
                it.let { certiAdapter.updateImtes(it)}
            })
            _isLoading.observe(viewLifecycleOwner,{
                binding.progressBar.visibility = if(it)  View.VISIBLE else View.GONE

            })
        }




    }
    private fun initRecyclerView(){
        certiAdapter = CertiAdapter()
        binding.recyclerView.apply {
            adapter = certiAdapter
        }
    }

}