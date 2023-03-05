package com.example.math_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var editTextName: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)

        // при нажатии на editText будем удалять строку текста
        editTextName?.setOnClickListener {
            editTextName?.text = null
        }
    }

    /**
     * сравнение чисел (три уровня сложности, 5, 20, 100)
     * сложение (три уровня сложности, 5+5, 10+10, 15+10+15)
     * вычитание (три уровня сложности, 5-5, 10-10, 15-10-2)
     * умножение (три уровня сложности, 5*5, 10*10, 15*15)
     * деление (три уровня сложности, 5/5, 10/10, 15/15)
     * сложные упражнения (три уровня сложности, 5+2*3, 10*15-30, 100/5-50)
     */

    fun goToSolutionActivity(v: View) {
        val intent = Intent(this, SolutionActivity::class.java)
        startActivity(intent)

        // нужно передать имя на финишную страницу
    }
}