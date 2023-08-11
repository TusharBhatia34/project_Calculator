package com.example.project1_calculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(modifier: Modifier, textColor: Color, text:String, onClick :()-> Unit) {
    Box(contentAlignment = Alignment.Center,modifier = Modifier
        .clip(CircleShape)
        .clickable { onClick() }
        .then(modifier)


    ){
        Text(text = text, fontSize = 28.sp, color = textColor)
    }
}