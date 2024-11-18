package com.dialiax.sweeto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dialiax.sweeto.adapter.DeliveryAdapter
import com.dialiax.sweeto.databinding.ActivityOutForDelivery2Binding

class OutForDeliveryActivity2 : AppCompatActivity() {
    private val binding: ActivityOutForDelivery2Binding by lazy {
        ActivityOutForDelivery2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.setOnClickListener{
            finish()
        }


        val customerNames = arrayOf(
            "Dibyaranjan",
            "Soumya",
            "Debasish"
        )

        val moneyStatuses = arrayOf(
            "received",
            "notReceived",
            "pending"
        )


        val customerNamesList = ArrayList(customerNames.toList())
        val moneyStatusesList = ArrayList(moneyStatuses.toList())

        // Set the adapter
        val adapter = DeliveryAdapter(customerNamesList, moneyStatusesList)
        binding.DeliveyRecyclerView.adapter = adapter
        binding.DeliveyRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
