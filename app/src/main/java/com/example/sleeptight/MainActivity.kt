package com.example.sleeptight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDemRealTime.setOnClickListener{
            var gio1 = calendar.get(Calendar.HOUR_OF_DAY)
            var phut1 = calendar.get(Calendar.MINUTE)
            var add = gio1.toString() + ":" + phut1.toString()
            textviewRealTime.text = add
            var gio = calendar.get(Calendar.HOUR_OF_DAY)
            var phut = calendar.get(Calendar.MINUTE)
            createTime(gio,phut)
        }
        btnDemChooseTime.setOnClickListener {
            val text : String = edtChooseTime.text.toString()
            val chars: CharArray = text.toCharArray()

            if(chars[0].toInt() > 2 || (chars[1].toInt() == 2 && chars[0].toInt() > 4)){
                finish()
            }
            if (chars[3].toInt() >= 6){
                finish()
            }

            else {

            }
        }

        // tý nữa làm 
    }
    fun createTime(gio : Int, phut: Int){

        var counthour = 2
        var countmin = 20
        var hourspend = 0
        var minspend = 0
        var timeadd : String = ""
        var timespend : String = ""
        var t=0
        var t1=0
        var arrayTime :ArrayList<Time> = ArrayList()
        for (i in 1 until 7){

            var tgio = gio + i*2;
            var tphut = phut + i*20;
            t=0;
            if (tphut >=60){
                t = tphut/60;
                tphut = tphut%60;
            }
            tgio+=t;
            if (tgio>=24){
                tgio = tgio-24;
            }
            var ttgio : String= ""
            var ttphut : String= ""
            if (tgio.toString().length == 1){
                ttgio = "0" + tgio.toString()
            } else ttgio = tgio.toString()
            if (tphut.toString().length == 1){
                ttphut = "0" + tphut.toString()
            } else ttphut = tphut.toString()
            timeadd  = (ttgio)+ ":" +(ttphut)

            hourspend =counthour*i
            minspend = countmin*i
            t1=0
            if (minspend >=60){
                t1 = minspend/60
                minspend = minspend%60
            }
            hourspend+=t1
            if (hourspend>=24){
                hourspend = hourspend-24
            }

            var t1hour = ""
            var t1min = ""
            if (hourspend.toString().length == 1){
                t1hour = "0" + hourspend
            } else t1hour = hourspend.toString()
            if (minspend.toString().length == 1){
                t1min = "0" + minspend
            } else t1min = minspend.toString()

            timespend = t1hour + ":" + t1min
            arrayTime.add(Time(timeadd,timespend))
        }
        listviewsleep.adapter = CustomAdapter(applicationContext,arrayTime)
    }
}