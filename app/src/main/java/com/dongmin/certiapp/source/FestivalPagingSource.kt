package com.dongmin.certiapp.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.dongmin.certiapp.data.festival.FestivalItem
import com.dongmin.certiapp.data.festival.FestivalItems
import com.dongmin.certiapp.repository.UserRepository
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.jetbrains.annotations.NotNull


class FestivalPagingSource(private val repository: UserRepository, private val serviceKey: String) :
    RxPagingSource<Int, FestivalItem>() {

    override fun getRefreshKey(state: PagingState<Int, FestivalItem>): Int? {
        return state.anchorPosition
        }


    override fun loadSingle(params: LoadParams<Int>): Single<PagingSource.LoadResult<Int, FestivalItem>> {

        var nextPageNumber = params.key
        if (nextPageNumber == null) {
            nextPageNumber = 1
        }

        return repository.getFestivalList(serviceKey = serviceKey, nextPageNumber = nextPageNumber)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it.resFestival.body.items, nextPageNumber) }



    }

    private fun toLoadResult(festivals: FestivalItems, pageNum: Int): PagingSource.LoadResult<Int, FestivalItem>? {
        return PagingSource.LoadResult.Page(
            data = festivals.item,
            prevKey = if (pageNum == 1) null else pageNum - 1,
            nextKey = if (pageNum < 700 / 10)
                pageNum + 1 else null
        )
    }


}