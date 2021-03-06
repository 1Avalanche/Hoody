//package com.anisimova.hoody.ui
//
//import android.content.pm.PackageManager
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.ImageView
//import android.widget.Toast
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.constraintlayout.widget.ConstraintLayout
//import androidx.core.content.ContextCompat
//import androidx.lifecycle.ViewModelProvider
//import com.example.hoody.R
//
//class Type8 : AppCompatActivity(), ButtonsPaletteFragment.Callbacks {
//
//    private lateinit var hoodRight: ImageView
//    private lateinit var hoodLeft: ImageView
//    private lateinit var sleeveRight: ImageView
//    private lateinit var sleeveRightTop: ImageView
//    private lateinit var body: ImageView
//    private lateinit var bodyTop: ImageView
//    private lateinit var bodyLine: ImageView
//    private lateinit var sleeveLeft: ImageView
//    private lateinit var sleeveLeftTop: ImageView
//    private lateinit var bottomSleeveRight: ImageView
//    private lateinit var bottomBody: ImageView
//    private lateinit var bottomSleeveLeft: ImageView
//    private lateinit var clearButton: ImageView
//    private lateinit var saveButton: ImageView
//    lateinit var fullHoody: ConstraintLayout
//
//    //создаем и подключаем к активити vm
//    private val hoodyType8ViewModel: HoodyTypeViewModel by lazy {
//        ViewModelProvider(this).get(HoodyTypeViewModel::class.java)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_type8)
//
//        //добавляет фрагмент-палетку
//        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
//        if (currentFragment == null){
//            val fragment = ButtonsPaletteFragment.newInstance()
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_container, fragment)
//                .commit()
//        }
//
//        //для запроса разрешения
//        val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
//            if (isGranted) {
//                hoodyType8ViewModel.saveHoody(fullHoody, this, resources.getString(R.string.folder_name))
//                Toast.makeText(this, resources.getString(R.string.toast_save), Toast.LENGTH_LONG).show()
//            } else { }
//        }
//
//
//        //передаем части худи VM
//        hoodRight = findViewById(R.id.hoodRight)
//        hoodLeft = findViewById(R.id.hoodLeft)
//        sleeveRight= findViewById(R.id.sleeveRight)
//        body = findViewById(R.id.body)
//        sleeveLeft = findViewById(R.id.sleeveLeft)
//        bottomSleeveRight = findViewById(R.id.sleeveRightBottom)
//        bottomBody = findViewById(R.id.bodyBottom)
//        bottomSleeveLeft = findViewById(R.id.sleeveLeftBottom)
//        sleeveRightTop= findViewById(R.id.sleeveRightTop)
//        bodyTop = findViewById(R.id.bodyTop)
//        sleeveLeftTop = findViewById(R.id.sleeveLeftTop)
//        bodyLine = findViewById(R.id.bodyLine)
//        var partList: MutableList<View> = mutableListOf(
//            hoodRight,
//            hoodLeft,
//            sleeveRight,
//            sleeveRightTop,
//            sleeveLeft,
//            sleeveLeftTop,
//            body,
//            bodyTop,
//            bodyLine,
//            bottomSleeveRight,
//            bottomSleeveLeft,
//            bottomBody)
//        hoodyType8ViewModel.loadParts(partList)
//
//        //работа кнопки очистить
//        clearButton = findViewById(R.id.clear_btn)
//        clearButton.setOnClickListener {
//            hoodyType8ViewModel.clear()
//        }
//
//        //работа кнопки сохранить
//        saveButton = findViewById(R.id.save_btn)
//        fullHoody = findViewById<ConstraintLayout>(R.id.layout_image)
//
//        saveButton.setOnClickListener {
//            //запрос разрешения
//            when {
//                ContextCompat.checkSelfPermission(
//                    this,
//                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
//                ) == PackageManager.PERMISSION_GRANTED -> {
//                    //если разрешено, сохраняем в галерею
//                    hoodyType8ViewModel.saveHoody(fullHoody, this, resources.getString(R.string.folder_name))
//                    Toast.makeText(this, resources.getString(R.string.toast_save), Toast.LENGTH_LONG).show()
//                }
//                else -> {
//                    requestPermissionLauncher.launch(
//                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                }
//            }
//
//        }
//
//
//    }
//
//    override fun onButtonClicked(color: List<Int>?)  {
//        if(color != null) hoodyType8ViewModel.makeFilter(color)
//
//    }
//
//}
