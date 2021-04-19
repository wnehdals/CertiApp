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
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FestivalFragment : ViewBindingFragment<FragmentFestivalBinding>() {
    override val layoutId = R.layout.fragment_festival
    private val festivalViewModel: FestivalViewModel by viewModel()
    lateinit var festivalAdapter: FestivalAdapter
    private var festivalJob: Job? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        festivalAdapter = FestivalAdapter()
        binding.festivalRecyclerView.adapter = festivalAdapter.withLoadStateFooter(
            footer = FestivalLoadStateAdapter { festivalAdapter.retry() })
        getFestivalItem()
    }
    private fun getFestivalItem(){
        Log.e("dfd","getfestivalitem")
        //festivalJob?.cancel()
        festivalJob = lifecycleScope.launch {
            festivalViewModel.getFestivalPagingSource(CertiApplication.dataApiKey)
                .collectLatest {
                    festivalAdapter.submitData(it)
                }
        }
    }
}