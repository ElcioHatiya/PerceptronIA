package com.example.perceptronia

import android.graphics.Color
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

            if(o.N1A.text.isEmpty()||o.N1B.text.isEmpty()||o.N1C.text.isEmpty()||o.N1C.text.isEmpty()||
               o.N2A.text.isEmpty()||o.N2B.text.isEmpty()||o.N2C.text.isEmpty()||o.N2D.text.isEmpty()||
               o.esperadoA.text.isEmpty()||o.esperadoB.text.isEmpty()||o.esperadoC.text.isEmpty()||o.esperadoD.text.isEmpty()||
               o.WBias.text.isEmpty()||o.WN1.text.isEmpty()||o.WN2.text.isEmpty()) {
                Toast.makeText(this@MainActivity,"Preencha todos os campos!", Toast.LENGTH_LONG).show()
               } else{
                var bias = 1
                var taxaAprendizagem = 1
                var acerto = 0

                fun calcularSaida(N1:Int, N2:Int, WBias:Int, WN1:Int, WN2:Int):Int{
                    var S = ((bias*WBias)+(N1*WN1)+(N2*WN2))
                    if(S>=1)S=1
                    else S=0
                    return S
                }

                fun verificarERRO(result:Int, esperado:Int):Int{
                    if(result==esperado) return 0
                    else return 1
                }

                var N1a = Integer.valueOf(o.N1A.text.toString()); var N1b = Integer.valueOf(o.N1B.text.toString())
                var N1c = Integer.valueOf(o.N1C.text.toString()); var N1d = Integer.valueOf(o.N1D.text.toString())
                var N2a = Integer.valueOf(o.N2A.text.toString()); var N2b = Integer.valueOf(o.N2B.text.toString())
                var N2c = Integer.valueOf(o.N2C.text.toString()); var N2d = Integer.valueOf(o.N2D.text.toString())
                var esperadoA = Integer.valueOf(o.esperadoA.text.toString()); var esperadoB = Integer.valueOf(o.esperadoB.text.toString())
                var esperadoC = Integer.valueOf(o.esperadoC.text.toString()); var esperadoD = Integer.valueOf(o.esperadoD.text.toString())
                var wb = Integer.valueOf(o.WBias.text.toString()); var w1 = Integer.valueOf(o.WN1.text.toString())
                var w2 = Integer.valueOf(o.WN2.text.toString());

                var saidaA = calcularSaida(N1a, N2a, wb, w1, w2)

                var erroA = verificarERRO(saidaA,esperadoA)

                if(erroA==0){
                    o.rsltA.text=esperadoA.toString()
                    o.rsltA.setTextColor(Color.GREEN)
                    acerto = 25
                }else{
                    if(esperadoA==0){
                        o.rsltA.text="1"
                        o.rsltA.setTextColor(Color.RED)
                    }else{
                        o.rsltA.text="0"
                        o.rsltA.setTextColor(Color.RED)
                    }
                }

                var saidaB = calcularSaida(N1b, N2b, wb, w1, w2)

                var erroB = verificarERRO(saidaB,esperadoB)

                if(erroB==0){
                    o.rsltB.text=esperadoB.toString()
                    o.rsltB.setTextColor(Color.GREEN)
                    acerto += 25
                }else{
                    if(esperadoB==0){
                        o.rsltB.text="1"
                        o.rsltB.setTextColor(Color.RED)
                    }else{
                        o.rsltB.text="0"
                        o.rsltB.setTextColor(Color.RED)
                    }
                }

                var saidaC = calcularSaida(N1c, N2c, wb, w1, w2)

                var erroC = verificarERRO(saidaC,esperadoC)

                if(erroC==0){
                    o.rsltC.text=esperadoC.toString()
                    o.rsltC.setTextColor(Color.GREEN)
                    acerto += 25
                }else{
                    if(esperadoC==0){
                        o.rsltC.text="1"
                        o.rsltC.setTextColor(Color.RED)
                    }else{
                        o.rsltC.text="0"
                        o.rsltC.setTextColor(Color.RED)
                    }
                }

                var saidaD = calcularSaida(N1d, N2d, wb, w1, w2)

                var erroD = verificarERRO(saidaD,esperadoD)

                if(erroD==0){
                    o.rsltD.text=esperadoD.toString()
                    o.rsltD.setTextColor(Color.GREEN)
                    acerto += 25
                }else{
                    if(esperadoD==0){
                        o.rsltD.text="1"
                        o.rsltD.setTextColor(Color.RED)
                    }else{
                        o.rsltD.text="0"
                        o.rsltD.setTextColor(Color.RED)
                    }
                }
                o.porcentagem.text=acerto.toString()+" %"
            }
        }
    }
}

