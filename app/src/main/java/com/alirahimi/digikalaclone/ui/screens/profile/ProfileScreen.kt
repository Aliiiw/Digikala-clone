package com.alirahimi.digikalaclone.ui.screens.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.selectedBottomBar
import com.alirahimi.digikalaclone.ui.theme.semiDarkText
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.util.Constants.USER_PHONE
import com.alirahimi.digikalaclone.util.DigitHelper.digitByLocate
import com.alirahimi.digikalaclone.viewmodel.DataStoreViewModel
import com.alirahimi.digikalaclone.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    if (!dataStore.getUserToken().isNullOrBlank()) {
        Profile()
    } else {
        when (profileViewModel.screenState) {
            ProfileScreenState.LOGIN_STATE -> {
                LoginScreen()
            }

            ProfileScreenState.PROFILE_STATE -> {
                Profile()
            }

            ProfileScreenState.REGISTER_STATE -> {
                RegisterScreen()
            }
        }
    }
}

@Composable
fun Profile() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 60.dp)
    ) {
        item { ProfileTopBarSection() }
        item { ProfileHeaderSection() }
    }
}

@Composable
private fun ProfileTopBarSection() {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.digi_settings),
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        horizontal = MaterialTheme.spacing.small,
                        vertical = MaterialTheme.spacing.small
                    )
                    .size(MaterialTheme.spacing.semiLarge),
                tint = MaterialTheme.colors.selectedBottomBar
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "",
                modifier = Modifier.padding(MaterialTheme.spacing.small),
                tint = MaterialTheme.colors.selectedBottomBar
            )
        }
    }
}

@Composable
fun ProfileHeaderSection() {
    Spacer(modifier = Modifier.height(MaterialTheme.spacing.bigMedium))

    Text(
        text = "user name",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )

    Text(
        text = digitByLocate(USER_PHONE),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h6,
        color = MaterialTheme.colors.semiDarkText
    )

    Spacer(modifier = Modifier.height(MaterialTheme.spacing.bigMedium))

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier
                .weight(0.49f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_score),
                contentDescription = "",
                modifier = Modifier.size(42.dp)
            )

            Column(
                modifier = Modifier
                    .padding(MaterialTheme.spacing.semiMedium)
            ) {
                Row(
                    modifier = Modifier.padding(bottom = MaterialTheme.spacing.extraSmall),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${digitByLocate("234")}",
                        color = MaterialTheme.colors.semiDarkText,
                        style = MaterialTheme.typography.h5
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = stringResource(id = R.string.score),
                        color = MaterialTheme.colors.semiDarkText,
                        style = MaterialTheme.typography.h6
                    )
                }

                Text(
                    text = stringResource(id = R.string.digikala_score),
                    color = MaterialTheme.colors.darkText,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Divider(
            modifier = Modifier
                .width(2.dp)
                .height(60.dp)
                .alpha(0.2f), color = Color.LightGray
        )

        Column(
            modifier = Modifier
                .weight(0.49f),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_wallet),
                contentDescription = "",
                modifier = Modifier.size(34.dp)
            )

            Text(
                modifier = Modifier.padding(top = MaterialTheme.spacing.small),
                text = stringResource(id = R.string.digikala_wallet_active),
                color = MaterialTheme.colors.darkText,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
        }
    }

    Spacer(modifier = Modifier.height(MaterialTheme.spacing.bigMedium))
}
