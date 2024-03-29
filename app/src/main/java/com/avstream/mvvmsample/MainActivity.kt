package com.avstream.mvvmsample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.avstream.mvvmsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val mainModel by viewModels<MainViewModel>()
        binding.viewModel = mainModel
        binding.lifecycleOwner = this

        mainModel.fst.observe(this) {
            binding.mainRecycler.adapter = NoteRecyclerAdapter(mainModel, it)
        }
    }
}