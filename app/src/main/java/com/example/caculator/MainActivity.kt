package com.example.caculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val listBtnNumber:MutableList<Button>?= mutableListOf()
    val listActions:MutableList<Button>?= mutableListOf()
    var isBegin=true;
    var action:String?=null
    var number1:Double?=null
    var number2:Double?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listBtnNumber?.add(btn_0)
        listBtnNumber?.add(btn_1)
        listBtnNumber?.add(btn_2)
        listBtnNumber?.add(btn_3)
        listBtnNumber?.add(btn_4)
        listBtnNumber?.add(btn_5)
        listBtnNumber?.add(btn_6)
        listBtnNumber?.add(btn_7)
        listBtnNumber?.add(btn_8)
        listBtnNumber?.add(btn_9)
        listBtnNumber?.add(btn_poin)

        listActions?.add(btn_plus)
        listActions?.add(btn_min)
        listActions?.add(btn_mul)
        listActions?.add(btn_div)

        setUpEvent()

    }
    private fun setUpEvent()
    {
        listBtnNumber?.forEach {
            val btn=it
            it.setOnClickListener {
                var text:String=textView_rs.text.toString()
                if(isBegin)
                {
                    text=""
                    isBegin=false
                }
                textView_rs.text=text+btn.text
            }
        }
        listActions?.forEach {
            val btn=it
            it.setOnClickListener {
                action=btn.text.toString()
                if(number1!=null)
                {
                    number2=textView_rs.text.toString().toDouble()

                    calc()
                    textView_rs.text=number1.toString()
                }else{
                    number1=textView_rs.text.toString().toDouble()

                }
                isBegin=true



            }
        }
        btn_equal.setOnClickListener {
            number2=textView_rs.text.toString().toDouble()
            calc()
            textView_rs.text=number1.toString()
            isBegin=true
            number2=null
            number1=null
        }
    }
    private fun calc()
    {
        if(action=="+")
        {
            number1=number1!!+number2!!
        }
        if(action=="-")
        {
            number1=number1!!-number2!!
        }
        if(action=="x")
        {
            number1=number1!!*number2!!
        }
        if(action=="÷")
        {
            number1=number1!!/number2!!
        }
    }
}