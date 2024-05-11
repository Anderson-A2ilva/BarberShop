package com.example.agendabarba.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agendabarba.MainActivity
import com.example.agendabarba.R
import com.example.agendabarba.adapter.ServicosAdapter
import com.example.agendabarba.databinding.ActivityHomeBinding
import com.example.agendabarba.model.Servicos

class Home : AppCompatActivity() {
    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    private lateinit var servicosAdapter: ServicosAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        binding.textoNomeUsuario.text = "Bem-vindo(a), $nome"
        val recyclerViewServicos = binding.recyclerviewServicos
        recyclerViewServicos.layoutManager = GridLayoutManager(this,2)
        servicosAdapter = ServicosAdapter(this, listaServicos)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = servicosAdapter
        getServicos()

        binding.botaoAgendarmento.setOnClickListener {
            val intent = Intent(this, Agendamento::class.java)
            intent.putExtra("nome", nome)
            startActivity(intent)
        }
    }

    private fun getServicos(){
        val servico1 = Servicos(R.drawable.tesoura, "Corte de cabelo")
        listaServicos.add(servico1)

        val servico2 = Servicos(R.drawable.barba, "Corte de barba")
        listaServicos.add(servico2)

        val servico3 = Servicos(R.drawable.lavagem, "Lavagem de cabelo")
        listaServicos.add(servico3)

        val servico4 = Servicos(R.drawable.produtos1, "Tratamento de cabelo")
        listaServicos.add(servico4)
    }
}
