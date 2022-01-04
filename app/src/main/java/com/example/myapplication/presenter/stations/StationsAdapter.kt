package com.example.myapplication.presenter.stations

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentStationsBinding
import com.example.myapplication.databinding.ItemStationBinding
import com.example.myapplication.domain.Station

class StationsAdapter: RecyclerView.Adapter<StationsAdapter.ViewHolder>() {

    var data: List<Station> = emptyList()

    var onItemClickListener:((Station) -> Unit)? = null
    var onFavoriteClickListener: ((Station) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
       return ViewHolder(ItemStationBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
       return data.size
    }

    inner class ViewHolder(private val binding: ItemStationBinding) :RecyclerView.ViewHolder(binding.root){

        init {
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(data[adapterPosition])
            }

            binding.favorite.setOnClickListener{
                onFavoriteClickListener?.invoke(data[adapterPosition])
            }
        }

        fun bind(station: Station){
            binding.badgeContainer.removeAllViews()

            station.connectedSubways
                .forEach{ subway ->
//                    binding.badgeContainer.addView(
//                        Badge(binding.root.context).apply{
//                            badgeColor = subway.color
//                            text = subway.label
//                            layoutParams=
//                                LinearLayout.LayoutParams(
//                                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                                    LinearLayout.LayoutParams.WRAP_CONTENT
//                                ).apply {
//                                    rightMargin = dip(6f)
//                                }
//                        }
//                    )
                }
        }

    }






}










