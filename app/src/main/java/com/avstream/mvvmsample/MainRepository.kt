package com.avstream.mvvmsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.Random

object MainRepository {

    private val titles: List<String> = listOf("Home", "Calendar", "Car", "Key", "Bed", "Furniture", "Clock", "Work")
    private val _currentTitle = MutableLiveData<String>()
    val currentTitle : LiveData<String>
        get() = _currentTitle

    init {
        _currentTitle.value = titles.first()
    }

    fun getRandomTitle(): String {
        val random = Random()
        return titles[random.nextInt(titles.size)]
    }

    fun changeCurrentTitle() {
        _currentTitle.value = getRandomTitle()
    }

 }