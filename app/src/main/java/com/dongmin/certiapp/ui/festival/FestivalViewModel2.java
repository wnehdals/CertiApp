package com.dongmin.certiapp.ui.festival;

import android.graphics.Movie;

import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;
import androidx.paging.rxjava3.PagingRx;

import com.dongmin.certiapp.base.ViewModelBase;
import com.dongmin.certiapp.data.festival.FestivalItem;
import com.dongmin.certiapp.repository.UserRepository;
import com.dongmin.certiapp.source.FestivalPagingSource;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import kotlinx.coroutines.CoroutineScope;

public class FestivalViewModel2 extends ViewModelBase {
    public Observable<PagingData<FestivalItem>> pagingDataFlow;
    private FestivalPagingSource festivalPagingSource;
    private UserRepository userRepository;
    public FestivalViewModel2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void setFestivalList(String serviceKey){
        festivalPagingSource = new FestivalPagingSource(userRepository, serviceKey);
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        Pager<Integer, FestivalItem> pager = new Pager(
                // Create new paging config
                new PagingConfig(20),// maxSize - Count of total items to be shown in recyclerview
                () -> festivalPagingSource); // set paging source

        // inti Flowable
        pagingDataFlow = PagingRx.getObservable(pager);

        PagingRx.cachedIn(pagingDataFlow, coroutineScope);

    }
}
