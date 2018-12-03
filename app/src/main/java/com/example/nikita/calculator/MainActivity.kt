@file:Suppress("DEPRECATION")

package com.example.nikita.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fNum = findViewById<EditText>(R.id.FirstNum)
        val sNum = findViewById<EditText>(R.id.SecondNum)

        val plusB = findViewById<Button>(R.id.PlusButton)
        val minusB = findViewById<Button>(R.id.MinusButton)
        val multB = findViewById<Button>(R.id.MultiplyButton)
        val divB = findViewById<Button>(R.id.DivisionButton)

        val resultV = findViewById<TextView>(R.id.ResultView)

        fun num1(): BigDecimal{
            return BigDecimal(fNum.text.toString())
        }
        fun num2(): BigDecimal{
            return BigDecimal(sNum.text.toString())
        }

        //Математические операции
        fun operations(op: String) {
            //Проверка на пустоту строк
            if (fNum.text.isEmpty() || sNum.text.isEmpty()){
                Toast.makeText(applicationContext, "Ошибка, не все поля заполнены!", Toast.LENGTH_SHORT).show()
                return
            }

            when (op){
                "+" -> {
                    resultV.text = (num1() + num2()).toString()
                }
                "-" -> {
                    resultV.text = (num1() - num2()).toString()
                }
                "*" -> {
                    resultV.text = (num1() * num2()).toString()
                }
                "/" -> {
                    //Проверка деления на ноль
                    if (sNum.text.toString() == 0.toString()){
                        Toast.makeText(applicationContext, "Ошибка, попытка деления на ноль!", Toast.LENGTH_SHORT).show()
                        return
                    }
                    resultV.text = (num1() / num2()).toString()
                }
            }
        }

        //Непосредственное взаимодействие с кнопками
        plusB.setOnClickListener {
            operations("+")
        }
        minusB.setOnClickListener {
            operations("-")
        }
        multB.setOnClickListener {
            operations("*")
        }
        divB.setOnClickListener {
            operations("/")
        }
    }
}
