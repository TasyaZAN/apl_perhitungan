package com.example.apl_perhitungan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BilanganAdapter (private  val dataSet: MutableList<databilangan>) : RecyclerView.Adapter<BilanganAdapter.BilanganHolder>() {

    class BilanganHolder(view: View):RecyclerView.ViewHolder(view) {
        val hasil = view.findViewById<TextView>(R.id.tvhasil)
        val btnhapus = view.findViewById<ImageButton>(R.id.btndelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):BilanganHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.bilangan_adapter,parent,false)
        return  BilanganHolder(view)

    }

    override fun onBindViewHolder(holder:BilanganHolder, position: Int) {
       holder.hasil.text = dataSet [position].hasilhitungan
        holder.btnhapus.setOnClickListener{
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position,dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
