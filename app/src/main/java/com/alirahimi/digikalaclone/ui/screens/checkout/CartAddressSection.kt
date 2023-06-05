package com.alirahimi.digikalaclone.ui.screens.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.ui.theme.extraSmall
import com.alirahimi.digikalaclone.ui.theme.lightCyan
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.viewmodel.AddressViewModel

@Composable
fun CartAddressSection(
    navController: NavHostController, viewModel: AddressViewModel = hiltViewModel()
) {
    val address = stringResource(id = R.string.no_address)
    val addressTextButton = stringResource(id = R.string.add_address)

    Row(
        Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.location),
            contentDescription = "",
            modifier = Modifier
                .size(22.dp)
                .weight(0.15f)
                .align(Alignment.CenterVertically)
        )

        Column(
            modifier = Modifier
                .weight(0.85f)
                .padding(MaterialTheme.spacing.medium),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.send_to),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.body2,
                color = Color.Gray
            )

            Text(
                text = address,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold,
                maxLines = 3
            )

            Text(
                text = "addressName",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1
            )
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.medium),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = addressTextButton,
            modifier = Modifier
                .padding(MaterialTheme.spacing.extraSmall)
                .clickable { },
            style = MaterialTheme.typography.extraSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.lightCyan
        )

        Icon(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "",
            tint = MaterialTheme.colors.lightCyan,
            modifier = Modifier
                .size(12.dp)
                .align(CenterVertically)
        )
    }


    Divider(
        modifier = Modifier
            .padding(vertical = MaterialTheme.spacing.medium)
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
            .alpha(0.4f)
            .shadow(2.dp),
        color = Color.LightGray
    )
}