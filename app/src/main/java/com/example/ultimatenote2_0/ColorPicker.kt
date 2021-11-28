package com.example.ultimatenote2_0

object ColorPicker {
    val colors = arrayOf(
        "#F8E586","#F896B7","#E492F3","#74CEF6","#8BEC8F","#F1B967",
        "#E68282"
    )
    var currentColorIndex=0

    fun getColor():String{
        currentColorIndex=(currentColorIndex+1)% colors.size
        return colors[currentColorIndex]
    }
}