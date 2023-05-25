package com.elacosta.eletriccarapp.ui.fragments

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Base64InputStream
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.elacosta.eletriccarapp.R
import com.elacosta.eletriccarapp.data.CarFactory
import com.elacosta.eletriccarapp.ui.CalculateConsumptionActivity
import com.elacosta.eletriccarapp.ui.adapter.CarAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import kotlin.math.log

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

    inner class AsyncTask {
        suspend fun execute(vararg url: String): String = withContext(Dispatchers.IO) {
            // Executa o código em uma CoroutineDispatcher de E/S para operações de rede

            var urlConnection: HttpURLConnection? = null

            try {
                val urlBase = URL(url[0])
                // Abre conexão com a internet
                urlConnection = urlBase.openConnection() as HttpURLConnection
                urlConnection.connectTimeout = 60000
                urlConnection.readTimeout = 60000

                val inString = streamToString(urlConnection.inputStream)
                // Atualiza o progresso em outra CoroutineDispatcher, se necessário

                inString
            } catch (ex: Exception) {
                // Trata erros durante o processamento em segundo plano
                Log.e("Erro", "Erro ao realizar processamento")
                ""
            } finally {
                urlConnection?.disconnect()
            }
        }

        private fun onProgressUpdate(vararg values: String) {
            try {
                var json: JSONObject
                values[0].let {
                    json = JSONObject(it)
                }
            } catch (ex: Exception) {
                Log.e("Erro", "Erro ao conectar com o JSON")
            }
        }

        // Converte um InputStream em uma String
        private fun streamToString(inputStream: InputStream): String {
            val bufferReader = BufferedReader(InputStreamReader(inputStream))
            var line: String?
            val result = StringBuilder()

            try {
                do {
                    line = bufferReader.readLine()
                    line?.let {
                        result.append(line)
                    }
                } while (line != null)
            } catch (ex: Exception) {
                // Trata erros durante a leitura do stream
                Log.e("erro", "Erro ao processar Stream")
            }

            return result.toString()
        }
    }
}