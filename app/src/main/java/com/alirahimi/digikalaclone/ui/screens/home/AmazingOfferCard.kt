package com.alirahimi.digikalaclone.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.ui.components.IconRotation
import com.alirahimi.digikalaclone.util.Constants

@Composable
fun AmazingOfferCard(topImageId: Int, bottomImageId: Int) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .height(380.dp)
            .padding(
                vertical = MaterialTheme.spacing.medium,
                horizontal = MaterialTheme.spacing.extraSmall
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp),
            painter = amazingLogoChangeByLanguage(),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.height(15.dp))

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            painter = painterResource(id = bottomImageId),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = stringResource(id = R.string.see_all),
                style = MaterialTheme.typography.h6,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            IconRotation(imageVector = Icons.Filled.KeyboardArrowLeft)
        }
    }
}

@Composable
private fun amazingLogoChangeByLanguage(): Painter {
    return if (Constants.USER_LANGUAGE == Constants.ENGLISH_LANGUAGE) {
        painterResource(id = R.drawable.amazing_en)
    } else {
        painterResource(id = R.drawable.amazings)
    }
}