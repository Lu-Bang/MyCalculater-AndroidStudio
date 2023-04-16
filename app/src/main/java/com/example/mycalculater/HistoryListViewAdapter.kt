package com.example.mycalculater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class HistoryListViewAdapter(listResult: List<String>, context: Context) : BaseAdapter() {
    private var listResult: List<String> = emptyList()
    private var context: Context

    init {
        this.listResult = listResult
        this.context = context
    }
    override fun getCount(): Int {
        return listResult.size
    }

    override fun getItem(p0: Int): Any {
        return listResult[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val item = listResult[p0]
        var convertView = p1
        convertView = LayoutInflater.from(context).inflate(R.layout.history_item, p2 , false)
        val title = convertView.findViewById<TextView>(R.id.title)
        title.text = item
        val time = convertView.findViewById<TextView>(R.id.time)
        val currentTime = Calendar.getInstance().time
        val format = SimpleDateFormat("dd/MM/yyyy")
        time.text = format.format(currentTime).toString()
        return convertView
    }
}