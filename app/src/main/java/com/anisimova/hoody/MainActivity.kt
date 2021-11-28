package com.anisimova.hoody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment
import com.anisimova.hoody.ui.*
import com.example.hoody.R


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

//        val scaleAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.scale)
//
//        val btnType1: ImageView = findViewById(R.id.to_type_1)
//        btnType1.setOnClickListener {
//            val intent = Intent(this, Type1::class.java)
//            startActivity(intent)
//            it.startAnimation(scaleAnimation)
//        }
//
//        val btnType2: ImageView = findViewById(R.id.to_type_2)
//        btnType2.setOnClickListener {
//            val intent = Intent(this, Type2::class.java)
//            startActivity(intent)
//            it.startAnimation(scaleAnimation)
//        }
//
//        val btnType3: ImageView = findViewById(R.id.to_type_3)
//        btnType3.setOnClickListener {
//            val intent = Intent(this, Type3::class.java)
//            startActivity(intent)
//            it.startAnimation(scaleAnimation)
//        }
//        val btnType4: ImageView = findViewById(R.id.to_type_4)
//        btnType4.setOnClickListener {
//            val intent = Intent(this, Type4::class.java)
//            startActivity(intent)
//            it.startAnimation(scaleAnimation)
//        }
//
//        val btnType5: ImageView = findViewById(R.id.to_type_5)
//        btnType5.setOnClickListener {
//            val intent = Intent(this, Type5::class.java)
//            startActivity(intent)
//            it.startAnimation(scaleAnimation)
//        }
//
//        val btnType6: ImageView = findViewById(R.id.to_type_6)
//        btnType6.setOnClickListener {
//            val intent = Intent(this, Type6::class.java)
//            startActivity(intent)
//            it.startAnimation(scaleAnimation)
//        }
//
//        val btnType7: ImageView = findViewById(R.id.to_type_7)
//        btnType7.setOnClickListener {
//            val intent = Intent(this, Type7::class.java)
//            startActivity(intent)
//            it.startAnimation(scaleAnimation)
//        }
//
//        val btnType8: ImageView = findViewById(R.id.to_type_8)
//        btnType8.setOnClickListener {
//            val intent = Intent(this, Type8::class.java)
//            startActivity(intent)
//            it.startAnimation(scaleAnimation)
//        }



    }



}
