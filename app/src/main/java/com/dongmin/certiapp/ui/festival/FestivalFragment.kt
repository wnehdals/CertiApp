package com.dongmin.certiapp.ui.festival

import android.os.Bundle
import android.view.View
import com.dongmin.certiapp.CertiApplication
import com.dongmin.certiapp.R
import com.dongmin.certiapp.base.ViewBindingFragment
import com.dongmin.certiapp.databinding.FragmentFestivalBinding
import com.dongmin.certiapp.ui.festival.adapter.FestivalAdapter
import com.dongmin.certiapp.ui.festival.adapter.FestivalComparator
import com.dongmin.certiapp.ui.festival.adapter.FestivalLoadStateAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FestivalFragment : ViewBindingFragment<FragmentFestivalBinding>() {
    private val festivalViewModel: FestivalViewModel2 by viewModel()
    override val layoutId = R.layout.fragment_festival
    lateinit var festivalAdapter: FestivalAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        festivalAdapter = FestivalAdapter(FestivalComparator())
        festivalViewModel.setFestivalList(CertiApplication.dataApiKey)
        binding.festivalRecyclerView.adapter = festivalAdapter.withLoadStateFooter(
            FestivalLoadStateAdapter { festivalAdapter.retry()})

        festivalViewModel.pagingDataFlow
            .subscribe{ it -> festivalAdapter.submitData(lifecycle, it)}


    }
}