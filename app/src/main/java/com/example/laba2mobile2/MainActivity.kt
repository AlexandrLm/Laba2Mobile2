package com.example.laba2mobile2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var turns : Boolean = true
    lateinit var but : Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        but = Array(3) { Array(3) { findViewById(R.id.button1) } }
        but[0] = arrayOf(findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3))     // первая строка таблицы
        but[1] = arrayOf(findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6))    // вторая строка таблицы
        but[2] = arrayOf(findViewById(R.id.button7), findViewById(R.id.button8), findViewById(R.id.button9))     // третья строка таблицы
    }

    fun pressButton(v : View) {
        var text : String = if (!turns) "x" else "o"
        when(v.id){
            R.id.button1 ->{
                changeTextOnButton(0, text)
            }
            R.id.button2 ->{
                changeTextOnButton(1, text)
            }
            R.id.button3 ->{
                changeTextOnButton(2, text)
            }

            R.id.button4 ->{
                changeTextOnButton(3, text)
            }
            R.id.button5 ->{
                changeTextOnButton(4, text)
            }
            R.id.button6 ->{
                changeTextOnButton(5, text)
            }

            R.id.button7 ->{
                changeTextOnButton(6, text)
            }
            R.id.button8 ->{
                changeTextOnButton(7, text)
            }
            R.id.button9 ->{
                changeTextOnButton(8, text)
            }
        }
        game()
    }
    fun switch(){
        val textWho : TextView = findViewById(R.id.who)
        if (!turns) {
            turns = true
            textWho.setText(R.string.nullsTurn)
        }
        else{
            turns = false
            textWho.setText(R.string.krestTurn)
        }
    }
    private fun changeTextOnButton(i : Int, text : String){
        if(but[i/3][i%3].text == "") {
            but[i/3][i%3].text = text
            switch()
        }
    }
    fun restart(v : View){
        var whoWin : TextView = findViewById(R.id.resultText)
        println("RESTART")

        for(row in but){
            for (n in  row) {
                n.text = ""
                n.isClickable = true
            }
        }

        whoWin.setText(R.string.resultMain)
    }
    private fun win(){
        for(row in but){
            for (n in  row)
                n.isClickable = false
        }
    }

    private fun game(){
        var whoWin : TextView = findViewById(R.id.resultText)

        for (row in but) {
            if (row[0].text == row[1].text && row[0].text == row[2].text) {
                if (row[0].text == "x") {
                    whoWin.setText(R.string.krestWin)
                    win()
                } else if (row[0].text == "o") {
                    whoWin.setText(R.string.nullsWin)
                    win()
                }
            }
        }

        for (i in 0..2) {
            if (but[0][i].text == but[1][i].text && but[0][i].text == but[2][i].text) {
                if (but[0][i].text == "x") {
                    whoWin.setText(R.string.krestWin)
                    win()
                } else if (but[0][i].text == "o") {
                    whoWin.setText(R.string.nullsWin)
                    win()
                }
            }
        }

        if (but[0][0].text == but[1][1].text && but[0][0].text == but[2][2].text) {
            if (but[1][1].text == "x") {
                whoWin.setText(R.string.krestWin)
                win()
            } else if (but[1][1].text == "o") {
                whoWin.setText(R.string.nullsWin)
                win()
            }
        }

        if (but[2][0].text == but[1][1].text && but[2][0].text == but[0][2].text) {
            if (but[1][1].text == "x") {
                whoWin.setText(R.string.krestWin)
                win()
            } else if (but[1][1].text == "o") {
                whoWin.setText(R.string.nullsWin)
                win()
            }
        }
    }
}