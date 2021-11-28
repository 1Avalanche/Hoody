package com.anisimova.hoody.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.anisimova.hoody.model.ColorButton
import com.example.hoody.R

interface Callbacks{
    fun onButtonClicked(color: List<Int>?)
}

class PaletteButtonAdapter(private val itemClickListener: Callbacks) : RecyclerView.Adapter<PaletteButtonAdapter.ButtonHolder>() {

    inner class ButtonHolder(view: View) : RecyclerView.ViewHolder(view) {

        val button1: Button = view.findViewById(R.id.color_button)
        val buttonsList = mutableListOf<ColorButton>()
        var colour: List<Int>? = null

        fun bind(index: Int){
            var colorButton = ColorButton(index, button1)
            colorButton.paint()
            colour = colorButton.color
            buttonsList.add(colorButton)
            itemView.setOnClickListener {
                itemClickListener.onButtonClicked(colour)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_color_button, parent, false)
        return ButtonHolder(view)
    }

    override fun getItemCount(): Int {
        var exampleButton = ColorButton(0, null)
        return exampleButton.bigColorList.size
    }

    override fun onBindViewHolder(holder: ButtonHolder, position: Int) {
        holder.bind(position)
    }

}
