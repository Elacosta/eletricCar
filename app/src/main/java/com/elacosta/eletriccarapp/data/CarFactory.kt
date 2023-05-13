package com.elacosta.eletriccarapp.data

import com.elacosta.eletriccarapp.domain.Car

//Tipo de classe padrão Singleton, tornando possivel acessar os dados sem precisar instanciar
object CarFactory {
    //Lista com os dados dos Carros
    val list = listOf(
        //Dados dos carros puxando a classe diretamente
        Car(
            id = 1,
            value = "860000",
            potency = "250 cv",
            batery = "300 KWh",
            recharge = "1 hour",
            urlPhoto = "url"
        ),
        Car(id = 2,
        value = "860000",
        potency = "250 cv",
        batery = "300 KWh",
        recharge = "1 hour",
        urlPhoto = "url"
    ),
        Car(id = 2,
            value = "860000",
            potency = "250 cv",
            batery = "300 KWh",
            recharge = "1 hour",
            urlPhoto = "url"
        )
    )
}