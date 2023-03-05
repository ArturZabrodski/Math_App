package com.example.math_app

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SolutionActivity : AppCompatActivity() {
    var textExample: TextView? = null
    var btnCheck: Button? = null
    var btnNext: Button? = null
    var btnFinish: Button? = null
    var editNumber: EditText? = null
    var textIncorrect: TextView? = null
    var textCorrect: TextView? = null
    var textMessage: TextView? = null
    var number_1: Int = 0
    var number_2: Int = 0
    var numberPoints: TextView? = null
    var resultCounts: Int = 0
    var totalCounts: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solution)

        textExample = findViewById(R.id.textExample)
        btnCheck = findViewById(R.id.btnCheck)
        btnNext = findViewById(R.id.btnNext)
        btnFinish = findViewById(R.id.btnFinish)
        editNumber = findViewById(R.id.editNumber)
        textCorrect = findViewById(R.id.textCorrect)
        textIncorrect = findViewById(R.id.textIncorrect)
        textMessage = findViewById(R.id.textMessage)
        numberPoints = findViewById(R.id.textPoints)
        numberPoints?.setTextColor(Color.BLUE)
        numberPoints?.setText("$resultCounts / $totalCounts")

        randomNumber()
    }

    fun randomNumber() {
        number_1 = (Math.random() * (5 - 1 + 1)).toInt() + 1
        number_2 = (Math.random() * (5 - 1 + 1)).toInt() + 1

        val strExample = "$number_1 + $number_2 = ?"
        textExample?.setText(strExample)
//        textExample?.setTextColor(Color.MAGENTA)
    }

    @SuppressLint("SetTextI18n")
    fun onClickButton(v: View) {
        if (editNumber?.text.toString().equals("")) {
            textMessage?.visibility = View.VISIBLE
        } else {
            val answer = editNumber?.text.toString().toInt()
            if (totalCounts < 9) {
                if (answer == (number_1 + number_2)) {
                    textCorrect?.visibility = View.VISIBLE
                    textMessage?.visibility = View.GONE
                    btnNext?.visibility = Button.VISIBLE
                    btnCheck?.visibility = Button.GONE
                    resultCounts++
                    totalCounts++
                } else {
                    textIncorrect?.visibility = View.VISIBLE
                    textMessage?.visibility = View.GONE
                    btnNext?.visibility = Button.VISIBLE
                    btnCheck?.visibility = Button.GONE
                    totalCounts++
                }
            } else if (totalCounts == 9) {
                if (answer == (number_1 + number_2)) {
                    textCorrect?.visibility = View.VISIBLE
                    textMessage?.visibility = View.GONE
                    btnNext?.visibility = Button.GONE
                    btnCheck?.visibility = Button.GONE
                    btnFinish?.visibility = Button.VISIBLE
                    resultCounts++
                    totalCounts++
                } else {
                    textIncorrect?.visibility = View.VISIBLE
                    textMessage?.visibility = View.GONE
                    btnNext?.visibility = Button.GONE
                    btnCheck?.visibility = Button.GONE
                    btnFinish?.visibility = Button.VISIBLE
                    totalCounts++
                }
            }
            numberPoints?.setText("$resultCounts / $totalCounts")
        }
    }

    fun onClickNext(v: View) {
        btnCheck?.visibility = Button.VISIBLE
        btnNext?.visibility = Button.GONE
        textCorrect?.visibility = View.GONE
        textIncorrect?.visibility = View.GONE
        textMessage?.visibility = View.GONE
        editNumber?.text = null
        randomNumber()
    }

    fun goToFinishActivity(v: View) {
        val intent = Intent(this, FinishActivity::class.java)
        intent.putExtra("result", numberPoints?.text.toString())
        startActivity(intent)
    }
}