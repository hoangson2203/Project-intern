package com.example.poemslesson1

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.poemslesson1.databinding.LayoutTopLosersBinding

class TopMarketAdapter(
    var todos: List<TopMarketModel>
) : RecyclerView.Adapter<TopMarketAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(val itemBinding: LayoutTopLosersBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutTopLosersBinding.inflate(
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
            tvChangeNumber.text = itemData.change.toString()
            tvPriceNumber.text = itemData.price
            tvLayoutTopLosers.text = itemData.countername
            tvSymbol.text = itemData.markets
            tvChangeNumber.setTextColor(ContextCompat.getColor(root.context, if (itemData.change < 0)
                R.color.red else R.color.green))
        }
    }


}