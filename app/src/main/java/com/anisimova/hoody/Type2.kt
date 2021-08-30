package com.anisimova.hoody

import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.hoody.R
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream


class Type2 : AppCompatActivity(), ButtonsPaletteFragment.Callbacks {

    private lateinit var hoodRight: ImageView
    private lateinit var hoodLeft: ImageView
    private lateinit var sleeveRight: ImageView
    private lateinit var body: ImageView
    private lateinit var sleeveLeft: ImageView
    private lateinit var bottomSleeveRight: ImageView
    private lateinit var bottomBody: ImageView
    private lateinit var bottomSleeveLeft: ImageView
    private lateinit var pocket: ImageView
    private lateinit var clearButton: ImageView
    private lateinit var saveButton: ImageView
    lateinit var fullHoody: ConstraintLayout

    //создаем и подключаем к активити vm
    private val hoodyType2ViewModel: HoodyTypeViewModel by lazy {
        ViewModelProvider(this).get(HoodyTypeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type2)

        //добавляет фрагмент-палетку
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null){
            val fragment = ButtonsPaletteFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }

        //для запроса разрешения
        val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                hoodyType2ViewModel.saveHoody(fullHoody, this, "Hoody Design")
            } else { }
        }


        //передаем части худи VM
        hoodRight = findViewById(R.id.hoodRight)
        hoodLeft = findViewById(R.id.hoodLeft)
        sleeveRight= findViewById(R.id.sleeveRight)
        body = findViewById(R.id.body)
        sleeveLeft = findViewById(R.id.sleeveLeft)
        bottomSleeveRight = findViewById(R.id.sleeveRightBottom)
        bottomBody = findViewById(R.id.bodyBottom)
        bottomSleeveLeft = findViewById(R.id.sleeveLeftBottom)
        pocket = findViewById(R.id.pocket)
        var partList: MutableList<View> = mutableListOf(
                hoodRight,
                hoodLeft,
                sleeveRight,
                sleeveLeft,
                body,
                bottomSleeveRight,
                bottomSleeveLeft,
                bottomBody,
                pocket)
        hoodyType2ViewModel.loadParts(partList)

        //работа кнопки очистить
        clearButton = findViewById(R.id.clear_btn)
        clearButton.setOnClickListener {
            hoodyType2ViewModel.clear()
        }

        //работа кнопки сохранить
        saveButton = findViewById(R.id.save_btn)
        fullHoody = findViewById<ConstraintLayout>(R.id.layout_image)

        saveButton.setOnClickListener {
            //запрос разрешения
            when {
                ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    //если разрешено, сохраняем в галерею
                    hoodyType2ViewModel.saveHoody(fullHoody, this, "Hoody-Woody")
                    Toast.makeText(this, "Your hoody was saved into your gallery!", Toast.LENGTH_LONG).show()
                }
                else -> {
                    requestPermissionLauncher.launch(
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }

        }


    }

    override fun onButtonClicked(color: List<Int>?)  {
        if(color != null) hoodyType2ViewModel.makeFilter(color)

    }

}
