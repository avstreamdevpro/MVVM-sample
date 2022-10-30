package com.huntcontrol.mvvmsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainRecycler: RecyclerView
    private lateinit var btnSubmit: Button
    private lateinit var edtTitle: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit = findViewById(R.id.btnSubmit)
        edtTitle = findViewById(R.id.edtTitle)
        mainRecycler = findViewById(R.id.mainRecycler)

        viewModel = MainViewModel()
        btnSubmit.setOnClickListener {
            addData()
        }
        initialiseAdapter()
    }


    private fun initialiseAdapter() {
        // init custom layout manager or etc
        observeData()
    }

    private fun observeData() {
        viewModel.fst.observe(this, Observer {
            mainRecycler.adapter = NoteRecyclerAdapter(viewModel, it)
        })
    }

    private fun addData() {
        val title = edtTitle.text.toString()
        if (title.isNullOrEmpty()) {
            Toast.makeText(this, "Please enter title!", Toast.LENGTH_LONG).show()
        } else {
            val blog = Blog(title)
            viewModel.add(blog)
            edtTitle.text.clear()
            mainRecycler.adapter?.notifyDataSetChanged()
        }
    }
}