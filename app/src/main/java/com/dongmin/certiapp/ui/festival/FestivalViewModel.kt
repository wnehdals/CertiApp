package com.dongmin.certiapp.ui.festival

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dongmin.certiapp.base.ViewModelBase
import com.dongmin.certiapp.data.festival.FestivalItem
import com.dongmin.certiapp.repository.UserRepository
import com.dongmin.certiapp.source.FestivalPagingSource
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

class FestivalViewModel(private val userRepository: UserRepository): ViewModelBase() {

    var currentSearchResult: Flow<PagingData<FestivalItem>>? = null
    fun getFestivalPagingSource(serviceKey: String): Flow<PagingData<FestivalItem>>{
        val newResult = Pager(PagingConfig(pageSize = 20)){
            FestivalPagingSource(userRepository, serviceKey)
        }.flow
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}

