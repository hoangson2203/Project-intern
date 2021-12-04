package com.example.poemslesson1

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.poemslesson1.databinding.LayoutTopLosersBinding
import com.example.poemslesson1.databinding.LayoutTopPerformingBinding

class TopPerformAdapter(
    var todos: List<TopPerformModel>
) : RecyclerView.Adapter<TopPerformAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(val itemBinding: LayoutTopPerformingBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutTopPerformingBinding.inflate(
                LayoutInflater.from(parent.context as Activity),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val itemData = todos[position]
        holder.itemBinding.apply {
            tvIndicesTopPerforming.text = itemData.countername
            tvPercentNumber.text = itemData.percent.toString()
            tvNameProduct.text = itemData.name
            tvCounterChange.text = itemData.change.toString()
        }
    }


}