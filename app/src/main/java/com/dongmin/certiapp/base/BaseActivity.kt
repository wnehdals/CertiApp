package com.dongmin.certiapp.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.dongmin.certiapp.R

abstract class BaseActivity<B : ViewDataBinding> (
    @LayoutRes val layoutId: Int) : AppCompatActivity(){
    lateinit var binding: B
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
}