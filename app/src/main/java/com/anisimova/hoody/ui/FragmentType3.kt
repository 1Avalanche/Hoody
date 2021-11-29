package com.anisimova.hoody.ui

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hoody.R

class FragmentType3 : Fragment(), Callbacks {

    private lateinit var hoodRight: ImageView
    private lateinit var hoodLeft: ImageView
    private lateinit var sleeveRight: ImageView
    private lateinit var sleeveRightTop: ImageView
    private lateinit var body: ImageView
    private lateinit var bodyTop: ImageView
    private lateinit var sleeveLeft: ImageView
    private lateinit var sleeveLeftTop: ImageView
    private lateinit var bottomSleeveRight: ImageView
    private lateinit var bottomBody: ImageView
    private lateinit var bottomSleeveLeft: ImageView
    private lateinit var pocket: ImageView
    private lateinit var pocketSmall: ImageView
    private lateinit var clearButton: ImageView
    private lateinit var saveButton: ImageView
    private lateinit var bigPocketShow: ImageView
    private lateinit var smallPocketShow: ImageView
    private lateinit var bigOk: ImageView
    private lateinit var smallOk: ImageView
    lateinit var fullHoody: ConstraintLayout
    private lateinit var paletteRecyclerView: RecyclerView

    //создаем и подключаем к фрагменту вью модель
    private val viewModel: HoodyTypeViewModel by lazy {
        ViewModelProvider(this).get(HoodyTypeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_type3, container, false)
        paletteRecyclerView = view.findViewById(R.id.buttons_recycler_view)
        paletteRecyclerView.layoutManager = GridLayoutManager(context, 3, RecyclerView.HORIZONTAL, false)
        val adapter = PaletteButtonAdapter(this)
        paletteRecyclerView.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //для запроса разрешения
        val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                viewModel.saveHoody(fullHoody, requireContext(), resources.getString(R.string.folder_name))
                Toast.makeText(requireContext(), resources.getString(R.string.toast_save), Toast.LENGTH_LONG).show()
            } else { }
        }

        //передаем части худи VM
        hoodRight = view.findViewById(R.id.hoodRight)
        hoodLeft = view.findViewById(R.id.hoodLeft)
        sleeveRight= view.findViewById(R.id.sleeveRight)
        body = view.findViewById(R.id.body)
        sleeveLeft = view.findViewById(R.id.sleeveLeft)
        bottomSleeveRight = view.findViewById(R.id.sleeveRightBottom)
        bottomBody = view.findViewById(R.id.bodyBottom)
        bottomSleeveLeft = view.findViewById(R.id.sleeveLeftBottom)
        pocket = view.findViewById(R.id.pocket)
        sleeveRightTop= view.findViewById(R.id.sleeveRightTop)
        bodyTop = view.findViewById(R.id.bodyTop)
        sleeveLeftTop = view.findViewById(R.id.sleeveLeftTop)
        pocketSmall = view.findViewById(R.id.pocket_small)
        var partList: MutableList<View> = mutableListOf(
            hoodRight,
            hoodLeft,
            sleeveRight,
            sleeveRightTop,
            sleeveLeft,
            sleeveLeftTop,
            body,
            bodyTop,
            bottomSleeveRight,
            bottomSleeveLeft,
            bottomBody,
            pocket,
            pocketSmall)
        viewModel.loadParts(partList)

        //работа кнопки очистить
        clearButton = view.findViewById(R.id.clear_btn)
        clearButton.setOnClickListener {
            viewModel.clear()
        }

        //работа кнопки сохранить
        saveButton = view.findViewById(R.id.save_btn)
        fullHoody = view.findViewById<ConstraintLayout>(R.id.layout_image)

        //работа кнопок - добавления карманов
        bigPocketShow = view.findViewById(R.id.pocket_big_btn)
        bigOk = view.findViewById(R.id.pocket_big_ok)
        bigPocketShow.setOnClickListener {
            viewModel.showBigPocket()
        }

        smallOk = view.findViewById(R.id.pocket_small_ok)
        smallPocketShow = view.findViewById(R.id.pocket_small_btn)
        smallPocketShow.setOnClickListener {
            viewModel.showSmallPocket()
        }

        viewModel.isBigPocketShow.observe(viewLifecycleOwner, Observer {
            if(it) {
                pocket.visibility = View.VISIBLE
                bigOk.visibility = View.VISIBLE
            }
            if (!it) {
                pocket.visibility = View.GONE
                bigOk.visibility = View.GONE
            }
        })

        viewModel.isSmallPocketShow.observe(viewLifecycleOwner, Observer {
            if(it) {
                pocketSmall.visibility = View.VISIBLE
                smallOk.visibility = View.VISIBLE
            }
            if (!it) {
                pocketSmall.visibility = View.GONE
                smallOk.visibility = View.GONE
            }
        })

        saveButton.setOnClickListener {
            //запрос разрешения
            when {
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    //если разрешено, сохраняем в галерею
                    viewModel.saveHoody(fullHoody, requireContext(), resources.getString(R.string.folder_name))
                    Toast.makeText(requireContext(), resources.getString(R.string.toast_save), Toast.LENGTH_LONG).show()
                }
                else -> {
                    requestPermissionLauncher.launch(
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }

        }
    }

    override fun onButtonClicked(color: List<Int>?)  {
        if(color != null) viewModel.makeFilter(color)
    }

}