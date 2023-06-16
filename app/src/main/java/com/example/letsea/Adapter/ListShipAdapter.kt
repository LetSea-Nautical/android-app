package com.example.letsea.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.letsea.R
import com.example.letsea.Ship

class ShipAdapter(private val shipList: List<Ship>) :
    RecyclerView.Adapter<ShipAdapter.ShipViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_ship, parent, false)
        return ShipViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShipViewHolder, position: Int) {
        val ship = shipList[position]
        holder.bind(ship)
    }

    override fun getItemCount(): Int {
        return shipList.size
    }

    inner class ShipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.card_view)
        private val logoShip: ImageView = itemView.findViewById(R.id.logo_ship)
        private val itemName: TextView = itemView.findViewById(R.id.tv_item_name)
        private val itemMMSI: TextView = itemView.findViewById(R.id.tv_item_mmsi)
        private val btnTrackDetail: Button = itemView.findViewById(R.id.btn_track_detail)
        private val btnVesselDetail: Button = itemView.findViewById(R.id.btn_vessel_detail)

        fun bind(ship: Ship) {
            // Set ship data to views
            itemName.text = ship.name
            itemMMSI.text = ship.mmsi

            // Set click listeners for buttons if needed
            btnTrackDetail.setOnClickListener {
                // Handle track detail button click
            }

            btnVesselDetail.setOnClickListener {
                // Handle vessel detail button click
            }
        }
    }
}