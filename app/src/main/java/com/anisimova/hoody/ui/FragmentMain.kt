package com.anisimova.hoody.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.hoody.R

class FragmentMain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnType1: ImageView = view.findViewById(R.id.to_type_1)
        val btnType2: ImageView = view.findViewById(R.id.to_type_2)
        val btnType3: ImageView = view.findViewById(R.id.to_type_3)
        val btnType4: ImageView = view.findViewById(R.id.to_type_4)
        val btnType5: ImageView = view.findViewById(R.id.to_type_5)
        val btnType6: ImageView = view.findViewById(R.id.to_type_6)
        val btnType7: ImageView = view.findViewById(R.id.to_type_7)
        val btnType8: ImageView = view.findViewById(R.id.to_type_8)

        btnType1.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentType1)
        }

        btnType2.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentType2)
        }

        btnType3.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentType3)
        }

        btnType4.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentType4)
        }

        btnType5.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentType5)
        }

        btnType6.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentType6)
        }

        btnType7.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentType7)
        }


    }

}