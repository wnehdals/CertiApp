package com.dongmin.certiapp.ui.festival

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dongmin.certiapp.base.ViewModelBase
import com.dongmin.certiapp.data.festival.FestivalItem
import com.dongmin.certiapp.repository.UserRepository
import com.dongmin.certiapp.source.FestivalPagingSource
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class FestivalViewModel(private val userRepository: UserRepository): ViewModelBase() {
    lateinit var festivalPagingSource: FestivalPagingSource

    fun getFestivalList(serviceKey: String){

    }
    private fun getFestivalListStream(serviceKey: String): Flow<PagingData<FestivalItem>> {
        var pager: Pager<Int, FestivalItem> = Pager(PagingConfig(20)){
            FestivalPagingSource(repository = userRepository, serviceKey = serviceKey)
        }

        return pager.flow
    }

}

sealed class FestivalModel{
    data class FestivalAdapterItem(val festivalItem: FestivalItem) : FestivalModel()
    data class SeparatorItem(val description: String) : FestivalModel()
}