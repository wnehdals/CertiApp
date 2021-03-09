package com.dongmin.certiapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dongmin.certiapp.base.ViewModelBase
import com.dongmin.certiapp.data.Item
import com.dongmin.certiapp.repository.UserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class HomeViewModel(private val userRepository: UserRepository) : ViewModelBase() {
    private val _certiList = MutableLiveData<ArrayList<Item>>()
    val certiList: LiveData<ArrayList<Item>> get() = _certiList

    val _isLoading = MutableLiveData<Boolean>()


    fun getCertiList(serviceKey: String) {
        userRepository.getCertiList(serviceKey = serviceKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _isLoading.value = true }
            .doAfterTerminate { _isLoading.value = false }
            .subscribe(
                { data ->
                    Log.d("HomeViewModel", "${data.resCertification}")
                   _certiList.value = data.resCertification.body.items.item
                },
                { error -> Log.e("viewmodel", error.message) },
            )

            .addTo(compositeDisposable)
    }

    fun getMastFetch() {
        Log.e("viewmodel", "getMaskFetch")
        userRepository.getMask()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _isLoading.value = true }
            .doAfterTerminate { _isLoading.value = false }

            .subscribe({ data -> Log.e("viewmodel", data.stores.get(0).name) },
                { error -> Log.e("error", error.message) })
            .addTo(compositeDisposable)
    }

}