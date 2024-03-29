package com.avstream.mvvmsample

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel: ObservableViewModel(){
    var fst = MutableLiveData<ArrayList<Blog>>()
    private var newList = arrayListOf<Blog>()

    private val _currentTitle = MutableLiveData<String>()
    val currentTitle: LiveData<String>
        get() = _currentTitle

    @Bindable
    var editedTitle : String = ""
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.editedTitle)
            }
        }

    private val _currentRandomTitle = MutableLiveData<String>()
    val currentRandomTitle : LiveData<String>
        get() = _currentRandomTitle

    init {
        _currentTitle.value = MainRepository.currentTitle.value
        _currentRandomTitle.value = MainRepository.getRandomTitle()
    }

    private fun addBlog(blog: Blog) {
        newList.add(blog)
        fst.value = newList
    }

    fun removeBlog(blog: Blog) {
        newList.remove(blog)
        fst.value = newList
    }

    fun onChangeTitle() {
        MainRepository.changeCurrentTitle()
        _currentTitle.value = MainRepository.currentTitle.value
    }

    fun onSubmit() {
        _currentTitle.value = editedTitle
        val title = editedTitle
        if (title.isNotEmpty()) {
            val blog = Blog(title)
            addBlog(blog)
        }
    }

    fun onSelectRandomTitle() {
        _currentRandomTitle.value = MainRepository.getRandomTitle()
    }




}