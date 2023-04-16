package com.example.mycalculater

import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class HistoryListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_listview_layout)
        setupList()
    }

    private fun setupList() {
        supportActionBar?.title = "HISTORY"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val listResult = intent.getStringArrayExtra("key_result")?.toList() ?: listOf<String>()
        val history = findViewById<ListView>(R.id.list_history)
        val adapter = HistoryListViewAdapter(listResult, this)
        history.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}