package com.anisimova.hoody

import android.graphics.Color
import android.widget.Button


class ColorButton (val index: Int, val button: Button) {

    var bigColorList = mutableListOf(
//main colors
        listOf(255, 0, 0, 0), //1   black
        listOf(255, 132, 132, 132),  //2 gray
        listOf(255, 255, 255, 255),   //3 white
        listOf(255, 2, 2, 140), //4 dark-blue
        listOf(255, 3, 3 , 252),  //5 blue
        listOf(255, 169, 169 ,255),  //6 light-blue
        listOf(255, 0, 147, 140),  //7 dark-cyan
        listOf(255, 0, 255, 255),  //8 cyan
        listOf(255, 192, 255, 253),  //9 light-cyan
        listOf(255, 0, 137, 0),  //10 dark-green
        listOf(255, 3, 252, 3),  //11 green
        listOf(255, 166, 252, 166),  //12  light-green
        listOf(255, 137, 140, 0),  //13 dark-yellow
        listOf(255, 255, 255, 0),  //14 yellow
        listOf(255, 255, 252, 148),  //15 light-yellow
        listOf(255, 119, 76, 0),  //16 dark-orange
        listOf(255, 255, 163, 0),  //17 orange
        listOf(255, 255, 214, 148),  //18 light-orange
        listOf(255, 150, 0, 0),  //19 dark-red
        listOf(255, 255, 0, 0), //20 red
        listOf(255, 255, 189, 189),  //21 light-red
        listOf(255, 142, 0, 85),  //22 dark-pink
        listOf(255, 255, 0, 164),  //23 pink
        listOf(255, 255, 159, 237),   //24 light-pink
        listOf(255, 95, 0, 109),  //25 dark-violet
        listOf(255, 223, 0, 225),  //26 violet
        listOf(255, 236, 146, 255),  //27 light-violet
// calm colors
        listOf(255, 30, 30, 30),  //28 dark-gray
        listOf(255, 81, 81, 81),  //29 gray
        listOf(255, 224, 224, 224),  //30 light-gary
        listOf(255, 54, 0, 96),  //31 dark-violet
        listOf(255, 119, 75, 170),  //32 violet
        listOf(255, 183, 163, 206),  //33 light-violet
        listOf(255, 0, 51, 86),  //34 dark-blue
        listOf(255, 58, 133, 175),  //35 blue
        listOf(255, 149, 188, 209),  //36 light-blue
        listOf(255, 0, 81, 54),  //37 dark-mint
        listOf(255, 52, 193, 142),  //38 mint
        listOf(255, 159, 221, 198),  //39 light-mint
        listOf(255, 63, 99, 0),  //40 dark-green
        listOf(255, 149, 191, 58),  //41 green
        listOf(255, 191, 214, 142),  //42 light-green
        listOf(255, 104, 47, 0),  //43 dark-jinjer
        listOf(255, 204, 115, 50),  //44 jinjer
        listOf(255, 224, 175, 141),  //45 light-jinjer
        listOf(255, 99, 0, 36),  //46  dark-pink
        listOf(255, 191, 58, 112),  //47 pink
        listOf(255, 211, 148, 174),  //48 light-pink
        listOf(255, 104, 0, 92),  //49 dark-violet
        listOf(255, 183, 78, 181),  //50 violet
        listOf(255, 221, 164, 217),  //51 light-violet
//neon colors
        listOf(255, 255, 0, 122),  //52 pink
        listOf(255, 255, 131, 196),  //53 middle-pink
        listOf(255, 255, 215, 237),  //54 light-pink
        listOf(255, 0, 170, 255),  //55 blue
        listOf(255, 133, 221, 255),  //56 middle-blue
        listOf(255, 193, 238, 255),  //55 light-blue
        listOf(255, 0, 255, 163),  //58 mint
        listOf(255, 153, 255, 213),  //59 middle-mint
        listOf(255, 204, 255,235),  //60 light-mint
        listOf(255, 156, 255, 0),  //61 green
        listOf(255, 214, 255, 123),  //62 middle-green
        listOf(255, 226, 255, 171),  //63 light-green
        listOf(255, 255, 109, 0),  //64 orange
        listOf(255, 255, 160, 95),  //65 middle-orange
        listOf(255, 255, 210, 179)  //66
    )

    var color = bigColorList[index]

    fun paint() = button.setBackgroundColor(Color.argb(color[0], color[1], color[2], color[3]))
}