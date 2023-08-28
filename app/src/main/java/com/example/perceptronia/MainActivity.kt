package com.example.perceptronia

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.perceptronia.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var o:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        o=ActivityMainBinding.inflate(layoutInflater)
        setContentView(o.root)

        o.btnCalc.setOnClickListener {

            var a1= o.spnA1.text.toString()
            var a2= o.spnA2.text.toString()
            var Sa3= o.spnA3.text.toString()
            var peso1 = o.peso1.text.toString()
            var b1= o.spnB1.text.toString()
            var b2= o.spnB2.text.toString()
            var Sb3= o.spnB3.text.toString()
            var peso2 = o.peso2.text.toString()
            var c1= o.spnC1.text.toString()
            var c2= o.spnC2.text.toString()
            var Sc3= o.spnC3.text.toString()
            var peso3 = o.peso3.text.toString()
            var d1= o.spnD1.text.toString()
            var d2= o.spnD2.text.toString()
            var Sd3= o.spnD3.text.toString()
            var peso4 = o.peso4.text.toString()

            var bias = 1
            var taxaAprendizagem = 1

            fun calcularSaida(x1:Int,x2:Int,peso:Int):Int{
                var S = ((Integer.valueOf(peso)*bias)+(peso*x1)+(peso*x2))
                return S
            }

            //Verifica se o Resultado é o mesmo que o Esperado
            fun verificarERRO(result:Int, esperado:Int):Int{
                if(result==esperado){return 0}
                else{return 1}
            }

            //Compara resultado com a saída esperada
            fun verificaResult(result:Int,saida:Int):Int{
                if(result==saida) return 0
                else return 1
            }

            if(a1.isEmpty()||a2.isEmpty()||Sa3.isEmpty()||b1.isEmpty()||b2.isEmpty()||Sb3.isEmpty()||
               c1.isEmpty()||c2.isEmpty()||Sc3.isEmpty()||d1.isEmpty()||d2.isEmpty()||Sd3.isEmpty())
                Toast.makeText(this@MainActivity,"Preencha todos os campos!", Toast.LENGTH_LONG).show()

            else{
                var A1=Integer.valueOf(a1)
                var A2=Integer.valueOf(a2)
                var A3=Integer.valueOf(Sa3)
                var P1=Integer.valueOf(peso1)
                var calc = calcularSaida(A1,A2,P1)
                Toast.makeText(this@MainActivity,calc.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}

