package com.example.todonew

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todonew.databinding.ViewBinding

class Adapter(private val data: List<CardInfo>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cardInfo: CardInfo) {
            with(binding) {
                title.text = cardInfo.title
                priority.text = cardInfo.priority

                val color = when (cardInfo.priority.toLowerCase()) {
                    "high" -> "#F05454"
                    "medium" -> "#EDC988"
                    else -> "#00917C"
                }
                mylayout.setBackgroundColor(Color.parseColor(color))

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, UpdateCard::class.java)
                    intent.putExtra("id", adapterPosition)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}
