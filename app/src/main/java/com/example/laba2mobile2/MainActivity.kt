package com.example.laba2mobile2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var turns : Boolean = true
    private lateinit var but : Array<Array<Button>>
    private var score : Array<Int> = Array(2) { 0 }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        but = Array(3) { Array(3) { findViewById(R.id.button1) } }
        but[0] = arrayOf(findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3))     // первая строка
        but[1] = arrayOf(findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6))     // вторая строка
        but[2] = arrayOf(findViewById(R.id.button7), findViewById(R.id.button8), findViewById(R.id.button9))     // третья строка
    }

    fun pressButton(v : View) {
        val text : String = if (!turns) "x" else "o"
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
        gameLogic()
    }
    private fun switchTurns(){
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
            switchTurns()
        }
    }
    fun restart(v : View){
        val whoWin : TextView = findViewById(R.id.resultText)
        println("RESTART")

        for(row in but){
            for (n in  row) {
                n.text = ""
                n.isClickable = true
            }
        }

        whoWin.setText(R.string.resultMain)
    }
    @SuppressLint("SetTextI18n")
    private fun win(text : Int){
        val whoWin : TextView = findViewById(R.id.resultText)
        val scoreT : TextView = findViewById(R.id.scoreText)
        for(row in but){
            for (n in  row)
                n.isClickable = false
        }
        whoWin.setText(text)
        scoreT.text = "X: ${score[0]}\nO: ${score[1]}"
    }

    private fun gameLogic(){
        for (row in but) {
            if (row[0].text == row[1].text && row[0].text == row[2].text) {
                if (row[0].text == "x") {
                    score[0]++
                    win(R.string.krestWin)
                } else if (row[0].text == "o") {
                    score[1]++
                    win(R.string.nullsWin)
                }
            }
        }

        for (i in 0..2) {
            if (but[0][i].text == but[1][i].text && but[0][i].text == but[2][i].text) {
                if (but[0][i].text == "x") {
                    score[0]++
                    win(R.string.krestWin)
                }
                else if (but[0][i].text == "o") {
                    score[1]++
                    win(R.string.nullsWin)
                }
            }
        }

        if (but[2][0].text == but[1][1].text && but[2][0].text == but[0][2].text ||
            but[0][0].text == but[1][1].text && but[0][0].text == but[2][2].text) {
            if (but[1][1].text == "x") {
                score[0]++
                win(R.string.krestWin)
            } else if (but[1][1].text == "o") {
                score[1]++
                win(R.string.nullsWin)
            }
        }

        var countEmptyButton : Int = 0
        for(row in but){
            for (n in  row) {
                if(n.text == ""){
                    countEmptyButton++
                }
            }
        }
        if (countEmptyButton == 0){
            win(R.string.draw)
        }
    }
}