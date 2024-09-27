package com.example.prova1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prova1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val custoPedagio = 10.50
    private val precoCombustivel = 5.85
    private val consumo = 12.0
    private val velocidadeMedia = 110.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val distanciaString = binding.editDistancia.text.toString()
            val pedagiosString = binding.editPedagios.text.toString()

            if (distanciaString.isNotEmpty() && pedagiosString.isNotEmpty()) {
                val distancia = distanciaString.toDoubleOrNull()
                val pedagios = pedagiosString.toDoubleOrNull()

                if (distancia != null && pedagios != null) {
                    val litrosNecessarios = distancia / consumo
                    val custoCombustivel = litrosNecessarios * precoCombustivel
                    val totalPedagio = pedagios * custoPedagio
                    val custoTotal = custoCombustivel + totalPedagio

                    val tempoViagemHoras = distancia / velocidadeMedia

                    val horas = tempoViagemHoras.toInt()
                    val minutos = ((tempoViagemHoras - horas) * 60).toInt()

                    binding.editResultado.text = String.format(
                        "Velocidade Média: %.0f km/h\n" +
                                "Custo por Pedágio: R$ %.2f\n" +
                                "Total Pedágios: R$ %.2f\n" +
                                "Preço Combustível: R$ %.2f\n" +
                                "Gasto Combustível: R$ %.2f\n" +
                                "Custo Total: R$ %.2f\n" +
                                "Tempo Estimado de Viagem: %d horas e %d minutos",
                        velocidadeMedia,
                        custoPedagio,
                        totalPedagio,
                        precoCombustivel,
                        custoCombustivel,
                        custoTotal,
                        horas,
                        minutos
                    )
                } else {
                    binding.editResultado.text = "Entrada Inválida"
                }
            }
        }
    }
}