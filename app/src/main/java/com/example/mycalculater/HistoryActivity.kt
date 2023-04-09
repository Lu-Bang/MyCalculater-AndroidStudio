package com.example.mycalculater

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_layout)
        setupList()
    }

    private fun setupList() {
        val listResult = intent.getStringArrayListExtra("key_result")?.toList() ?: listOf<String>()
        val history = findViewById<ListView>(R.id.list_history)
        val adapter = HistoryAdapter(listResult, this)
        history.adapter = adapter
    }
}