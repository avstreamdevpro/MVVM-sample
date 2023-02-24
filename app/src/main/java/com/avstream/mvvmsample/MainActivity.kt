package com.avstream.mvvmsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
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