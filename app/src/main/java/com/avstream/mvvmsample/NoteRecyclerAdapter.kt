package com.avstream.mvvmsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRecyclerAdapter(val viewModel: MainViewModel, private val arrayList: ArrayList<Blog>): RecyclerView.Adapter<NoteRecyclerAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindView(arrayList[position])
    }

    override fun getItemCount(): Int {
        return  arrayList.size
    }


    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val txtTitle: TextView = itemView.findViewById(R.id.txt_title)
        private val imgDelete: ImageView = itemView.findViewById(R.id.img_delete)

        fun bindView(blog: Blog) {
            txtTitle.text = blog.title
            imgDelete.setOnClickListener {
                viewModel.removeBlog(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }
    }
}