package com.masterandroid.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.masterandroid.intent.model.User

class MainActivity : AppCompatActivity() {

    lateinit var tvFirst :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews(){
         tvFirst = findViewById<TextView>(R.id.tv_first)
        val btnEnter = findViewById<Button>(R.id.btn_enter)
        val user = User("Jabbor",22)
        btnEnter.setOnClickListener {
            openSecondActivity(user)
        }
    }
    var detailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == Activity.RESULT_OK){
            val data:Intent? = result.data
            val text = data!!.getStringExtra("result")
            tvFirst.text = text
        }
    }

    fun openSecondActivity(user: User) {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("user", user)
        detailLauncher.launch(intent)
    }
}