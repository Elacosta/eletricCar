package com.elacosta.eletriccarapp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.elacosta.eletriccarapp.R

class CalculateConsumptionActivity : AppCompatActivity() {

    //Cria variaveis com seus respectivos conteudos no Layout
    lateinit var value: EditText
    lateinit var btnCalculate: Button
    lateinit var traveled: EditText
    lateinit var result: TextView
    lateinit var btnClose: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_consumption)

        setupView()
        setupCalculateListener()
        setupCloseButton()
    }

    //Puxa a função calcular para o clique do botão
    fun setupCalculateListener() {
        btnCalculate.setOnClickListener {
            calculate()
        }
    }

    //Adiciona a função de finalizar tela ao clicar no botão Close
    fun setupCloseButton() {
        btnClose.setOnClickListener {
            finish()
        }
    }

    //Relaciona as variaveis aos conteudos no layout
    fun setupView() {
        value = findViewById(R.id.etKiloWhValue)
        btnCalculate = findViewById(R.id.btnCalculate)
        traveled = findViewById(R.id.etKMTraveled)
        result = findViewById(R.id.tvResult)
        btnClose = findViewById(R.id.ivClose)
    }

    //Pega as variaveis que foram preenchidas no Layout e realiza o calculo
    fun calculate() {
        val kiloWats = value.text.toString().toFloat() //Relaciona o valor "KiloWats" a variável Value
        val travel = traveled.text.toString().toFloat() //Relaciona o valor "travel" a variável traveled
        val energyConsumption = kiloWats / travel //calcula o consumo
        val formattedResult = String.format("%.2f", energyConsumption) //formata o resultado para sair apenas 3 decimais após a vírgula
        val resultMessage = resources.getString(R.string.resultAutonomy, formattedResult) //envia o resultado para uma string salva no placeholder
        result.text = resultMessage //setta o texto do placeholder no textview
    }
}