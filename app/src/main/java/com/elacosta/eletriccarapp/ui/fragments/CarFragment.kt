package com.elacosta.eletriccarapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.elacosta.eletriccarapp.R
import com.elacosta.eletriccarapp.data.CarFactory
import com.elacosta.eletriccarapp.ui.CalculateConsumptionActivity
import com.elacosta.eletriccarapp.ui.adapter.CarAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CarFragment : Fragment() {
    private lateinit var fabCalculate: FloatingActionButton
    lateinit var carList: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_car, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(view)
        setupList()
        setupListener()
    }

    //passado com parâmetro View pois não é possivel acessar o XML diretamente por não estar em um escopo de uma activity
    fun setupView(view: View) {
        view.apply {
            fabCalculate = findViewById(R.id.fabCalculate)
            carList = findViewById(R.id.rvMainScreen)
        }
    }

    //Conecta a lista de carros com o Adapter e puxa ele para a tela
    fun setupList() {
        val data = CarFactory.list
        val adapter = CarAdapter(data)
        carList.adapter = adapter
    }

    fun setupListener() {
        fabCalculate.setOnClickListener {
            startActivity(Intent(context, CalculateConsumptionActivity::class.java))
        }
    }
}