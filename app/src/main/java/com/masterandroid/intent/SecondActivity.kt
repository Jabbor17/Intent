package com.masterandroid.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.masterandroid.intent.model.User

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()
    }
    fun initViews(){
        val btnExit = findViewById<Button>(R.id.btn_exit)
        val tvSecond = findViewById<TextView>(R.id.tv_second)

        btnExit.setOnClickListener {
            backToFinish()
        }

        val user = intent.getSerializableExtra("user")
        tvSecond.text = user.toString()
    }

    fun backToFinish(){
        val intent = Intent()
        intent.putExtra("result","Thanks")
        setResult(RESULT_OK,intent)
        finish()
    }
}