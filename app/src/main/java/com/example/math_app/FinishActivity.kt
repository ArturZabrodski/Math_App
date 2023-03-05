package com.example.math_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class FinishActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val textResult = findViewById<TextView>(R.id.textResult)

        textResult?.setText(intent.getStringExtra("result"))
    }

    fun goToMainActivity(v: View) {
        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
    }

}