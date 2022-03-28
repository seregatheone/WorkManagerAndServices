package com.example.a19.ui.startFragment

import android.annotation.SuppressLint
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.a19.R
import com.example.a19.data.retrofit.CatFactModelModel

class RecViewAdapter : RecyclerView.Adapter<RecViewAdapter.MyViewHolder>() {

    var allData : List<CatFactModelModel> = emptyList()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = allData[position]

        val id = holder.itemView.findViewById<TextView>(R.id.fact)
        id.text = currentItem.fact

        val title = holder.itemView.findViewById<TextView>(R.id.length)
        title.text = currentItem.length.toString()

    }

    override fun getItemCount(): Int {
        return allData.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setRequestsData(requestsPool: CatFactModelModel){
        allData = listOf(requestsPool)
        notifyDataSetChanged()
    }
}