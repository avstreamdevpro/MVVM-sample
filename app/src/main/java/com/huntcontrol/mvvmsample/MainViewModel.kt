package com.huntcontrol.mvvmsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var fst = MutableLiveData<ArrayList<Blog>>()
    var newList = arrayListOf<Blog>()

    fun add(blog: Blog) {
        newList.add(blog)
        fst.value = newList
    }

    fun remove(blog: Blog) {
        newList.remove(blog)
        fst.value = newList
    }
}