package com.example.laba2mobile2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var turns : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun pressButton(v : View) {
        var But : Array<Button> = arrayOf(findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3),
            findViewById(R.id.button4), findViewById(R.id.button5), findViewById(R.id.button6),
            findViewById(R.id.button7), findViewById(R.id.button8), findViewById(R.id.button9))

        var text : String = if (turns == false) "x" else "o"
        when(v.id){
            R.id.button1 ->{
                changeTextOnButton(But, 0, text)
            }
            R.id.button2 ->{
                changeTextOnButton(But, 1, text)
            }
            R.id.button3 ->{
                changeTextOnButton(But, 2, text)
            }

            R.id.button4 ->{
                changeTextOnButton(But, 3, text)
            }
            R.id.button5 ->{
                changeTextOnButton(But, 4, text)
            }
            R.id.button6 ->{
                changeTextOnButton(But, 5, text)
            }

            R.id.button7 ->{
                changeTextOnButton(But, 6, text)
            }
            R.id.button8 ->{
                changeTextOnButton(But, 7, text)
            }
            R.id.button9 ->{
                changeTextOnButton(But, 8, text)
            }
        }
    }
    fun switch(){
        val textWho : TextView = findViewById(R.id.who)
        if (turns == false) {
            turns = true
            textWho.setText(R.string.nullsTurn)
        }
        else{
            turns = false
            textWho.setText(R.string.krestTurn)
        }
    }

    fun changeTextOnButton(but : Array<Button>, i : Int, text : String){
        if(but[i].text == "") {
            but[i].text = text
            switch()
        }
    }
    fun resrtart(){

    }
}