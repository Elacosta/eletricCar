package com.elacosta.eletriccarapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.elacosta.eletriccarapp.R
import com.elacosta.eletriccarapp.data.CarFactory
import com.elacosta.eletriccarapp.ui.adapter.CarAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var btnOpenMathScreen: Button
    lateinit var carList: RecyclerView

    //função OnCreate do app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Pega o conteudo da tela (Layout)
        setContentView(R.layout.activity_main)

        //Puxa as funções da tela
        setupView()
        setupList()
        setupListener()
    }

    //Conecta as variaveis com o conteudo do Layout
    fun setupView() {
        btnOpenMathScreen = findViewById(R.id.btnOpenCalculateScreen)
        carList = findViewById(R.id.rvMainScreen)
    }

    //Conecta a lista de carros com o Adapter e puxa ele para a tela
    fun setupList() {
        val data = CarFactory.list
        val adapter = CarAdapter(data)
        carList.adapter = adapter
    }

    //Ações realizadas em tela
    fun setupListener() {
        btnOpenMathScreen.setOnClickListener {
            startActivity(Intent(this, CalculateConsumptionActivity::class.java))
        }
    }
}