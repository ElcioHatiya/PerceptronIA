package com.example.perceptronia

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.perceptronia.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var o:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        o=ActivityMainBinding.inflate(layoutInflater)
        setContentView(o.root)

        var a1=Integer.valueOf(o.spnA1.text.toString())
        var a2=Integer.valueOf(o.spnA2.text.toString())
        var a3=Integer.valueOf(o.spnA3.text.toString())
        var b1=Integer.valueOf(o.spnB1.text.toString())
        var b2=Integer.valueOf(o.spnB2.text.toString())
        var b3=Integer.valueOf(o.spnB3.text.toString())
        var c1=Integer.valueOf(o.spnC1.text.toString())
        var c2=Integer.valueOf(o.spnC2.text.toString())
        var c3=Integer.valueOf(o.spnC3.text.toString())
        var d1=Integer.valueOf(o.spnD1.text.toString())
        var d2=Integer.valueOf(o.spnD2.text.toString())
        var d3=Integer.valueOf(o.spnD3.text.toString())

        var bias = 1
        var peso = 0

        fun calcularPeso(x1:Int,x2:Int,peso:Int):Int{
            var S = ((bias*peso)+(peso*x1)+(peso*x2))
            var erro = (a3-S)
            return S
        }
    }
}

