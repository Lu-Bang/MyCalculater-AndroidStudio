package com.example.mycalculater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.text.SimpleDateFormat
import java.util.*

class HistoryRecycleViewAdapter(val listResult: List<String>, val context: Context): RecyclerView.Adapter<HistoryRecycleViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val convertView = LayoutInflater.from(context).inflate(R.layout.history_item, parent, false)
        return ViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: HistoryRecycleViewAdapter.ViewHolder, position: Int) {
        val item = listResult[position]
        holder.bindData(item)
    }

    override fun getItemCount(): Int {
        return listResult.size
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private var  title: TextView
        private var time: TextView

        init {
            title = view.findViewById(R.id.title)
            time = view.findViewById(R.id.time)
        }

        fun bindData(item: String) {
            title.text = item
            val currentTime = Calendar.getInstance().time
            val format = SimpleDateFormat("dd/MM/yyyy")
            time.text = format.format(currentTime).toString()
        }
    }
}