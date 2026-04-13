package com.example.ubercloneapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ServiceAdapter(
    private val serviceList: List<ServiceItem>,
    private val onItemClick: (ServiceItem) -> Unit
) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    private var selectedPosition = 0

    inner class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardService: CardView = itemView.findViewById(R.id.cardService)
        val ivServiceIcon: ImageView = itemView.findViewById(R.id.ivServiceIcon)
        val tvServiceTitle: TextView = itemView.findViewById(R.id.tvServiceTitle)
        val tvBadge: TextView = itemView.findViewById(R.id.tvBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_service, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val item = serviceList[position]

        holder.ivServiceIcon.setImageResource(item.imageResId)
        holder.tvServiceTitle.text = item.title

        if (item.badgeText.isEmpty()) {
            holder.tvBadge.visibility = View.GONE
        } else {
            holder.tvBadge.visibility = View.VISIBLE
            holder.tvBadge.text = item.badgeText
        }

        if (position == selectedPosition) {
            holder.cardService.setCardBackgroundColor(0xFFE8F0FE.toInt())
        } else {
            holder.cardService.setCardBackgroundColor(0xFFFFFFFF.toInt())
        }

        holder.cardService.setOnClickListener {
            val oldPosition = selectedPosition
            selectedPosition = holder.adapterPosition
            notifyItemChanged(oldPosition)
            notifyItemChanged(selectedPosition)
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = serviceList.size
}