package com.example.mycalculater

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class HistoryRecycleViewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_recycleview_layout)
        setupUI()
    }
    private fun setupUI() {
        supportActionBar?.setTitle("HISTORY")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val listResult = intent.getStringArrayExtra("key_result")?.toList() ?: listOf<String>()
        val history = findViewById<RecyclerView>(R.id.recycleview_history)
        val adapter = HistoryRecycleViewAdapter(listResult, this)
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