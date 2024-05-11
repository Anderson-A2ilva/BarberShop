package com.example.agendabarba

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.agendabarba.databinding.ActivityMainBinding
import com.example.agendabarba.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.botaoLogin.setOnClickListener {
            val nome = binding.inputNome.editText?.text.toString()
            val senha = binding.inputSenha.editText?.toString()

            if (senha != null) {
                when {
                    nome.isEmpty() -> {
                        mensagem(it, "Coloque o seu nome")
                    }

                    senha.isEmpty() -> {
                        mensagem(it, "Preencha a senha!")
                    }

                    senha.length <= 5 -> {
                        mensagem(it, "A Senha precisa ter pelo menos 6 caracteres")
                    }

                    else -> {
                        navegarParaHome(nome)
                    }
                }
            }
        }
    }

    private fun mensagem(view: View, mensagem: String) {
        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.RED)
        snackbar.show()
    }

    private fun navegarParaHome(nome: String) {
        val intent = Intent(this, Home::class.java)
        intent.putExtra("nome", nome)
        startActivity(intent)
    }
}