package com.example.mycalculater

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mycalculater.model.CalculaterResult

class HistoryRecycleViewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_recycleview_layout)
        setupUI()
    }
    private fun setupUI() {
        supportActionBar?.title = "HISTORY"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val listResult = intent.getSerializableExtra("key_result") as? List<CalculaterResult> ?: listOf()
        val history = findViewById<RecyclerView>(R.id.recycleview_history)
        val adapter = HistoryRecycleViewAdapter(listResult, this)
        history.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}