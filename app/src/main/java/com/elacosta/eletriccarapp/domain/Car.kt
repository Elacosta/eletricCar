package com.elacosta.eletriccarapp.domain

//Classe que abstrai Getters, setters, construtor e toString
data class Car (
    val id: Int,
    val value: String,
    val batery: String,
    val potency: String,
    val recharge: String,
    val urlPhoto: String
)