package com.dongmin.certiapp.source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.dongmin.certiapp.data.festival.FestivalItem
import com.dongmin.certiapp.data.festival.FestivalItems
import com.dongmin.certiapp.data.festival.ResFestival
import com.dongmin.certiapp.repository.UserRepository
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.jetbrains.annotations.NotNull
import java.lang.Exception

private const val FESTIVAL_STARTING_PAGE_INDEX = 1
private const val FESTIVAL_LOADSIZE = 20
class FestivalPagingSource(private val repository: UserRepository, private val serviceKey: String) :
    PagingSource<Int, FestivalItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FestivalItem> {
        val nextPageNumber = params.key ?: FESTIVAL_STARTING_PAGE_INDEX
        return try{
            val response = repository.getFestivalList(serviceKey, nextPageNumber)
            val totalPage = response.resFestival.body.totalCount / FESTIVAL_LOADSIZE
            return LoadResult.Page(
                data = response.resFestival.body.items.item,
                prevKey = if(nextPageNumber == FESTIVAL_STARTING_PAGE_INDEX) null else nextPageNumber - 1,
                nextKey = if(nextPageNumber < totalPage) nextPageNumber + 1 else null
            )
        } catch (exception: Exception){
            Log.e("pagesource",exception.toString())
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, FestivalItem>): Int? {
        return state.anchorPosition
    }


/*
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

 */


}