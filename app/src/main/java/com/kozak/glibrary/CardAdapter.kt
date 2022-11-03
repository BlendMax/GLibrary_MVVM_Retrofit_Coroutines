package com.kozak.glibrary

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kozak.glibrary.databinding.CardSampleBinding

class CardAdapter(mutableListOf: MutableList<String>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    private var mutableList = mutableListOf

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CardSampleBinding.bind(itemView)

        fun bind(array: ArrayList<String>, item: Int) = with(binding) {

            val resources: Resources = itemView.context.resources
            val resourceId: Int = resources.getIdentifier(array[item].replace("-", "_"), "drawable", itemView.context.packageName)
            imageCardSample.setImageResource(resourceId)
            tvCardSample.text = array[item].replace("-", " ").uppercase()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_sample, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(mutableList as ArrayList<String>, position)

    }

    override fun getItemCount(): Int {
        return mutableList.size
    }


    fun addCharcter(newData: ArrayList<String>) {
        //mutableList.clear()
        mutableList = newData
        notifyDataSetChanged()
    }

}