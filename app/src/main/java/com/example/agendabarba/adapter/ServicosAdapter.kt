package com.example.agendabarba.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendabarba.databinding.ServicosItensBinding
import com.example.agendabarba.model.Servicos

class ServicosAdapter(
    private val context: Context,
    private val listaServicos: MutableList<Servicos>
) :
    RecyclerView.Adapter<ServicosAdapter.ServicosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicosViewHolder {
        val itemLista = ServicosItensBinding.inflate(LayoutInflater.from(context),parent,false)
        return  ServicosViewHolder(itemLista)
    }

    override fun getItemCount() = listaServicos.size

    override fun onBindViewHolder(holder: ServicosViewHolder, position: Int) {
        holder.imagemServicos.setImageResource(listaServicos[position].imagem!!)
        holder.tituloServicos.text = listaServicos[position].nome
    }

    inner class ServicosViewHolder(binding: ServicosItensBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imagemServicos = binding.imagemServicos
        val tituloServicos = binding.tituloServicos
    }
}