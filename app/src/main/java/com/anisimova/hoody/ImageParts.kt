package com.anisimova.hoody

import android.graphics.ColorMatrixColorFilter
import android.view.View
import android.widget.Filter
import android.widget.ImageView

class ImagePart(var imageView: View) {
    fun colorizePart(filter: ColorMatrixColorFilter?) {
        var imag = imageView as ImageView
        var myImg = imag.drawable
        myImg.colorFilter = filter
        imag.setImageDrawable(myImg)
        imag.invalidate()
    }
}
