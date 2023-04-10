package com.alirahimi.digikalaclone.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.alirahimi.digikalaclone.util.Constants.ENGLISH_LANGUAGE
import com.alirahimi.digikalaclone.util.Constants.USER_LANGUAGE

@Composable
fun IconRotation(imageVector: ImageVector) {

    if (USER_LANGUAGE == ENGLISH_LANGUAGE) {
        Icon(
            imageVector = imageVector,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .graphicsLayer(rotationZ = 180f)
                .size(40.dp)
        )
    } else {
        Icon(
            imageVector = imageVector,
            contentDescription = "",
            tint = Color.White,
        )
    }
}

@Composable
fun IconRotation(painter: Painter, tint: Color) {

    if (USER_LANGUAGE == ENGLISH_LANGUAGE) {
        Icon(
            painter = painter,
            contentDescription = "",
            tint = tint,
            modifier = Modifier
                .graphicsLayer(rotationZ = 180f)
                .size(40.dp)
        )
    } else {
        Icon(
            painter = painter,
            contentDescription = "",
            tint = tint,
        )
    }
}