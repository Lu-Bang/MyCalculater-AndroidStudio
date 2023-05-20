package com.example.mycalculater

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mycalculater.model.CalculaterResult
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var input: TextView
    private var var1 = ""
    private var var2 = ""
    private var method = ""
    private var value = ""
    private var listResult: ArrayList<CalculaterResult> = arrayListOf()
    private var resultLauncherLamda = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable("key_result", listResult)
        outState.putString("var1",var1)
        outState.putString("var2",var2)
        outState.putString("method",method)
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        listResult = savedInstanceState.getSerializable("key_result") as? ArrayList<CalculaterResult> ?: arrayListOf()
//        var value = var1 + method + var2
//        input.text = value
        input.text = listResult.last().result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        if (savedInstanceState != null) {
            var1 = savedInstanceState.getString("var1").toString()
            var2 = savedInstanceState.getString("var2").toString()
            method = savedInstanceState.getString("method").toString()
        }
        input = findViewById(R.id.input)
        setup()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.acion_history -> {
                goToHistory()
            }
            else -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun setup() {

        val num1 = findViewById<Button>(R.id.num1)
        num1.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = oldValue + "1"
            input.text = newValue
            if(method == "")
            {
                var1 += "1"
            }
            else
            {
                var2 += "1"
            }
        }
        val num2 = findViewById<Button>(R.id.num2)
        num2.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = oldValue + "2"
            input.text = newValue
            if(method == "")
            {
                var1 += "2"
            }
            else
            {
                var2 += "2"
            }
        }
        val num3 = findViewById<Button>(R.id.num3)
        num3.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = oldValue + "3"
            input.text = newValue
            if(method == "")
            {
                var1 += "3"
            }
            else
            {
                var2 += "3"
            }
        }
        val num4 = findViewById<Button>(R.id.num4)
        num4.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = oldValue + "4"
            input.text = newValue
            if(method == "")
            {
                var1 += "4"
            }
            else
            {
                var2 += "4"
            }
        }
        val num5 = findViewById<Button>(R.id.num5)
        num5.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = oldValue + "5"
            input.text = newValue
            if(method == "")
            {
                var1 += "5"
            }
            else
            {
                var2 += "5"
            }
        }
        val num6 = findViewById<Button>(R.id.num6)
        num6.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = oldValue + "6"
            input.text = newValue
            if(method == "")
            {
                var1 += "6"
            }
            else
            {
                var2 += "6"
            }
        }
        val num7 = findViewById<Button>(R.id.num7)
        num7.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = oldValue + "7"
            input.text = newValue
            if(method == "")
            {
                var1 += "7"
            }
            else
            {
                var2 += "7"
            }
        }
        val num8 = findViewById<Button>(R.id.num8)
        num8.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = oldValue + "8"
            input.text = newValue
            if(method == "")
            {
                var1 += "8"
            }
            else
            {
                var2 += "8"
            }
        }
        val num9 = findViewById<Button>(R.id.num9)
        num9.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = oldValue + "9"
            input.text = newValue
            if(method == "" )
            {
                var1 += "9"
            }
            else
            {
                var2 += "9"
            }
        }
        val num0 = findViewById<Button>(R.id.num0)
        num0.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = oldValue + "0"
            input.text = newValue
            if(method == "")
            {
                var1 += "0"
            }
            else
            {
                var2 += "0"
            }
        }
        val clear = findViewById<Button>(R.id.buttonAC)
        clear.setOnClickListener {
            var1 = ""
            var2 = ""
            method = ""
            input.text = ""
        }
        val cong = findViewById<Button>(R.id.buttonADD)
        cong.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = "$oldValue+"
            input.text = newValue
            method += "+"
        }
        val tru = findViewById<Button>(R.id.buttonSUB)
        tru.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = "$oldValue-"
            input.text = newValue
            method += "-"
        }
        val nhan = findViewById<Button>(R.id.buttonMUL)
        nhan.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = "$oldValue×"
            input.text = newValue
            method += "×"
        }
        val chia = findViewById<Button>(R.id.buttonDIV)
        chia.setOnClickListener {
            val oldValue = input.text.toString()
            val newValue = "$oldValue÷"
            input.text = newValue
            method += "÷"
        }
        val result = findViewById<Button>(R.id.buttonResult)
        result.setOnClickListener {
            val result = input.text.toString() + " = " + getResult()
            val time = Calendar.getInstance()
            val format = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
            listResult.add(CalculaterResult(result, format.format(time.time)))
            input.text = getResult()
        }
    }
    private fun goToHistory() {
        val intent = Intent(this,HistoryRecycleViewActivity::class.java)
        intent.putExtra("key_result", listResult)
        resultLauncherLamda.launch(intent)
    }
    private fun getResult(): String {
        val result: Float
        val finalResult: String
        when (method) {
            "" -> {
                finalResult=var1
            }
            "+" -> {
                result = var1.toFloat() + var2.toFloat()
                finalResult = result.toString()
            }
            "-" -> {
                result = var1.toFloat() - var2.toFloat()
                finalResult = result.toString()
            }
            "×" -> {
                result = var1.toFloat() * var2.toFloat()
                finalResult = result.toString()
            }
            "÷" -> {
                result = var1.toFloat() / var2.toFloat()
                finalResult = result.toString()
            }
            else -> {
                finalResult = "ERROR"
            }
        }
        return finalResult
    }
}

