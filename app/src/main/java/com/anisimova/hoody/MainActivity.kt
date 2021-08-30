package com.anisimova.hoody

import android.content.Intent
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Layout
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.hoody.R
import java.util.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scaleAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.scale)

        val btnType1: ImageView = findViewById(R.id.to_type_1)
        btnType1.setOnClickListener {
            val intent = Intent(this, Type1::class.java)
            startActivity(intent)
            it.startAnimation(scaleAnimation)
        }

        val btnType2: ImageView = findViewById(R.id.to_type_2)
        btnType2.setOnClickListener {
            val intent = Intent(this, Type2::class.java)
            startActivity(intent)
            it.startAnimation(scaleAnimation)
        }

        val btnType3: ImageView = findViewById(R.id.to_type_3)
        btnType3.setOnClickListener {
            val intent = Intent(this, Type3::class.java)
            startActivity(intent)
            it.startAnimation(scaleAnimation)
        }
        val btnType4: ImageView = findViewById(R.id.to_type_4)
        btnType4.setOnClickListener {
            val intent = Intent(this, Type4::class.java)
            startActivity(intent)
            it.startAnimation(scaleAnimation)
        }

        val btnType5: ImageView = findViewById(R.id.to_type_5)
        btnType5.setOnClickListener {
            val intent = Intent(this, Type5::class.java)
            startActivity(intent)
            it.startAnimation(scaleAnimation)
        }

        val btnType6: ImageView = findViewById(R.id.to_type_6)
        btnType6.setOnClickListener {
            val intent = Intent(this, Type6::class.java)
            startActivity(intent)
            it.startAnimation(scaleAnimation)
        }



    }



}
