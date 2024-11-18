package com.dialiax.sweeto.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dialiax.sweeto.databinding.DeliveryItemBinding

class DeliveryAdapter(
    private val customerNames: ArrayList<String>,
    private val moneyStatuses: ArrayList<String>
) : RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
        val binding = DeliveryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeliveryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = customerNames.size

    inner class DeliveryViewHolder(private val binding: DeliveryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
                // Set text for customer name and money status
                customerNameTextView.text = customerNames[position]
                moneyStatusTextView.text = moneyStatuses[position]

                // Define a color map for payment status
                val colorMap = mapOf(
                    "received" to Color.GREEN,
                    "notReceived" to Color.RED,
                    "pending" to Color.GRAY
                )

                // Set the text color for moneyStatusTextView based on payment status
                moneyStatusTextView.setTextColor(colorMap[moneyStatuses[position]] ?: Color.BLACK)


            }
        }
    }
}
