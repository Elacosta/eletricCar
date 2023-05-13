package com.elacosta.eletriccarapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elacosta.eletriccarapp.R
import com.elacosta.eletriccarapp.domain.Car
import org.w3c.dom.Text

class CarAdapter(private val cars: List<Car>) : RecyclerView.Adapter<CarAdapter.ViewHolder>(){

    //Chama o layout criado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    //Pega o conteudo da view e setta pelo conteudo do item da lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carValue.text = cars[position].value
        holder.carBatery.text = cars[position].batery
        holder.carPotency.text = cars[position].potency
        holder.carRecharge.text = cars[position].recharge
    }

    //pega a quantidade de carros da lista
    override fun getItemCount(): Int = cars.size

    //Cria o viewholder para puxar os dados da Lista
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val carValue : TextView
        var carBatery : TextView
        val carPotency : TextView
        val carRecharge : TextView
        init {
            //Relaciona as variáveis aos itens do Layout que terão seus valores settados pelos da Lista
            view.apply {
                carValue = findViewById(R.id.tvNumericCarValue)
                carBatery = findViewById(R.id.tvBateryValue)
                carPotency = findViewById(R.id.tvPotencyValue)
                carRecharge = findViewById(R.id.tvRechargeValue)
            }
        }
    }

}

