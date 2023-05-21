package com.elacosta.eletriccarapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.elacosta.eletriccarapp.R
import com.elacosta.eletriccarapp.data.CarFactory
import com.elacosta.eletriccarapp.ui.adapter.CarAdapter
import com.elacosta.eletriccarapp.ui.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tlMainScreen : TabLayout
    lateinit var vpMainScreen : ViewPager2

    //função OnCreate do app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Pega o conteudo da tela (Layout)
        setContentView(R.layout.activity_main)

        //Puxa as funções da tela
        setupView()
        setupListener()
        setupTab()
    }

    //Conecta as variaveis com o conteudo do Layout
    fun setupView() {
        tlMainScreen = findViewById(R.id.tlMain)
        vpMainScreen = findViewById(R.id.vpMainScreen)
    }

    fun setupTab() {
        val tabAdapter = TabAdapter(this)
        vpMainScreen.adapter = tabAdapter
    }

    //Ações realizadas em tela
    fun setupListener() {
        setupTabListener()
    }

    fun setupTabListener() {
        //gerenciamento do click do usuario na tab
        tlMainScreen.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            //No momento que a tab for selecionada
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //Checa se o item é ou não Null
                tab?.let {
                    vpMainScreen.currentItem = it.position
                }
            }

            //No momento que ela não está mais selecionada
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            //Momento em que a tab é selecionada novamente
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        //garante que a transição seja feita visualmente
        vpMainScreen.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tlMainScreen.getTabAt(position)?.select()
            }
        })
    }
}