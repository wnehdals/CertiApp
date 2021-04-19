package com.dongmin.certiapp.ui.festival

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.dongmin.certiapp.CertiApplication
import com.dongmin.certiapp.R
import com.dongmin.certiapp.base.ViewBindingFragment
import com.dongmin.certiapp.databinding.FragmentFestivalBinding
import com.dongmin.certiapp.ui.festival.adapter.FestivalAdapter
import com.dongmin.certiapp.ui.festival.adapter.FestivalLoadStateAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FestivalFragment : ViewBindingFragment<FragmentFestivalBinding>() {
    private val festivalViewModel: FestivalViewModel by viewModel()
    override val layoutId = R.layout.fragment_festival
    lateinit var festivalAdapter: FestivalAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        festivalAdapter = FestivalAdapter()
        //festivalViewModel.setFestivalPagingSource(CertiApplication.dataApiKey)
        binding.festivalRecyclerView.adapter = festivalAdapter.withLoadStateFooter(
            footer = FestivalLoadStateAdapter { festivalAdapter.retry() })

        lifecycleScope.launch {
            festivalViewModel.setFestivalPagingSource(CertiApplication.dataApiKey)
                .collectLatest {
                    Log.e("flow", it.toString())
                    festivalAdapter.submitData(it)
                }
        }
    }
}