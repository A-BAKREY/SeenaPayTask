package com.example.seenapaytask.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.seenapaytask.R
import com.example.seenapaytask.di.RecycleList
import kotlinx.android.synthetic.main.recycle_item.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>(){

    private var listOfData: List<RecycleList>? = null

    class ViewHolderClass(view: View): RecyclerView.ViewHolder(view){

        private val thumbImage: AppCompatImageView = view.image
        private val title: TextView = view.title
        private val rate: TextView = view.Rate
        private val publishedBy: TextView = view.publishedBy
        private val publishedDate: TextView = view.publishedDate

        fun bind(data: RecycleList){
            title.text = data.title
            publishedBy.text = data.type
            rate.text = data.abstract
            publishedDate.text = data.published_date
            Glide.with(thumbImage)
                .load(data.baseUrl?.url)
                .into(thumbImage)
        }

    }

    fun setListDate(listOfData: List<RecycleList>?){
        this.listOfData = listOfData
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item,parent,false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        holder.bind(listOfData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (listOfData == null){
            return 0
        }
        else {
            return listOfData?.size!!
        }
    }

    private var onItemClickListener: ((RecycleList) -> Unit)? = null
    fun setOnItemClickListener(listener: (RecycleList) -> Unit) {
        onItemClickListener = listener
    }

}