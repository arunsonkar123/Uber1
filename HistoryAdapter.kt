package com.example.ubercloneapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(
    private val historyList: List<RideItem>
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardHistory: CardView = itemView.findViewById(R.id.cardHistory)
        val tvRideService: TextView = itemView.findViewById(R.id.tvRideService)
        val tvRideRoute: TextView = itemView.findViewById(R.id.tvRideRoute)
        val tvRideFare: TextView = itemView.findViewById(R.id.tvRideFare)
        val tvRidePayment: TextView = itemView.findViewById(R.id.tvRidePayment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = historyList[position]
        holder.tvRideService.text = item.serviceName
        holder.tvRideRoute.text = "${item.pickup} → ${item.drop}"
        holder.tvRideFare.text = "Fare: ${item.fare}"
        holder.tvRidePayment.text = "Payment: ${item.paymentMode}"
    }

    override fun getItemCount(): Int = historyList.size
}