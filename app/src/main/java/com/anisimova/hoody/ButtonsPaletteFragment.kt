package com.anisimova.hoody

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.hoody.R

class ButtonsPaletteFragment: Fragment() {

    interface Callbacks{
        fun onButtonClicked(color: List<Int>?)
    }


    private lateinit var buttonsRecyclerView: RecyclerView
    private var adapter = ButtonAdapter()
    val buttonList = mutableListOf<Button>()
    private var callbacks: Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buttons_palette, container, false)
        buttonsRecyclerView = view.findViewById(R.id.buttons_recycler_view) as RecyclerView
        buttonsRecyclerView.layoutManager = GridLayoutManager(context, 3, HORIZONTAL, false)
        buttonsRecyclerView.adapter = adapter

        return view
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }


    private inner class ButtonAdapter : RecyclerView.Adapter<ButtonAdapter.ButtonHolder>() {


        inner class ButtonHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

            val button1: Button = view.findViewById(R.id.color_button)
            val buttonsList = mutableListOf<ColorButton>()
            var colour: List<Int>? = null

            init {
                itemView.setOnClickListener(this)
            }

            fun bind(index: Int){
                var colorButton = ColorButton(index, button1)
                colorButton.paint()
                colour = colorButton.color
                buttonsList.add(colorButton)
            }

            override fun onClick(v: View?) {
                callbacks?.onButtonClicked(colour)
            }


        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_color_button, parent, false)
            return ButtonHolder(view)
        }

        override fun getItemCount(): Int {
            return 66
        }

        override fun onBindViewHolder(holder: ButtonHolder, position: Int) {
            holder.bind(position)
        }

    }



    companion object {
        fun newInstance(): ButtonsPaletteFragment {
            return  ButtonsPaletteFragment()
        }

    }



}
    
