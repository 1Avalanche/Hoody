package com.anisimova.hoody.ui

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.drawToBitmap
import androidx.lifecycle.ViewModel
import com.anisimova.hoody.ImagePart
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class HoodyTypeViewModel : ViewModel() {

    private lateinit var partList: MutableList<View>
    lateinit var bitmap: Bitmap

    var colorMatrixWhite = floatArrayOf(
            1f, 0f, 0f, 0f, 0f,
            0f, 1f, 0f, 0f, 0f,
            0f, 0f, 1f, 0f, 0f,
            0f, 0f, 0f, 1f, 0f
    )
    var matrixWhite = ColorMatrix(colorMatrixWhite)
    var filterWhite = ColorMatrixColorFilter(matrixWhite)

    fun loadParts(parts: MutableList<View>) : MutableList<View> {
        partList = parts
        return partList

    }

    fun makeFilter(colorList: List<Int>) {
        if (colorList != null) {
            var red: Float = colorList[1].toFloat() / 255
            var green: Float = colorList[2].toFloat() / 255
            var blue: Float = colorList[3].toFloat() / 255
            var colorMatrix = floatArrayOf(
                red, 0f, 0f, 0f, 0f,
                0f, green, 0f, 0f, 0f,
                0f, 0f, blue, 0f, 0f,
                0f, 0f, 0f, 1f, 0f
            )
            var matrix = ColorMatrix(colorMatrix)
            val filter = ColorMatrixColorFilter(matrix)
            colorizePart(filter)}
    }

    fun colorizePart(filter: ColorMatrixColorFilter) {

        for (item in partList){
            item.setOnClickListener {
                var part = ImagePart(it)
                part.colorizePart(filter)
            }
        }
    }


    fun clear(){
        for (i in partList) {
            var part = ImagePart(i)
            part.colorizePart(filterWhite)
        }
    }

    //функци сохранения худи в виде фото в галерею
    fun saveHoody(fullHoody: ConstraintLayout, context: Context, folderName: String ){

        bitmap = fullHoody.drawToBitmap()

            if (android.os.Build.VERSION.SDK_INT >= 29) {
                val values = contentValues()
                values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/" + folderName)
                values.put(MediaStore.Images.Media.IS_PENDING, true)
                // RELATIVE_PATH and IS_PENDING are introduced in API 29.
                val uri: Uri? = context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
                if (uri != null) {
                    saveImageToStream(bitmap, context.contentResolver.openOutputStream(uri))
                    values.put(MediaStore.Images.Media.IS_PENDING, false)
                    context.contentResolver.update(uri, values, null, null)
                }
            } else {
                val directory = File(Environment.getExternalStorageDirectory().toString() + File.separator + folderName)
                // getExternalStorageDirectory is deprecated in API 29

                if (!directory.exists()) {
                    directory.mkdirs()
                }
                val fileName = System.currentTimeMillis().toString() + ".png"
                val file = File(directory, fileName)
                saveImageToStream(bitmap, FileOutputStream(file))
                if (file.absolutePath != null) {
                    val values = contentValues()
                    values.put(MediaStore.Images.Media.DATA, file.absolutePath)
                    // .DATA is deprecated in API 29
                    context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
                }
            }
        }

        private fun contentValues() : ContentValues {
            val values = ContentValues()
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/png")
            values.put(MediaStore.Images.Media.DATE_ADDED, System.currentTimeMillis() / 1000);
            values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
            return values
        }

        private fun saveImageToStream(bitmap: Bitmap, outputStream: OutputStream?) {
            if (outputStream != null) {
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                    outputStream.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

    }
