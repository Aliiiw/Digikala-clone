package com.alirahimi.digikalaclone.ui.screens.profile

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.data.remote.NetworkResult
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.selectedBottomBar
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.util.InputValidation.isValidPassword
import com.alirahimi.digikalaclone.viewmodel.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RegisterScreen(
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(Dispatchers.Main) {
        profileViewModel.loginResponseFlow.collectLatest { loginResponse ->
            when (loginResponse) {

                is NetworkResult.Success -> {
                    loginResponse.data?.let {
                        if (it.token.isNotEmpty()){
                            profileViewModel.screenState = ProfileScreenState.PROFILE_STATE
                        }
                    }
                    Toast.makeText(
                        context,
                        loginResponse.message,
                        Toast.LENGTH_LONG
                    ).show()
                    profileViewModel.loadingState = false
                }

                is NetworkResult.Error -> {
                    profileViewModel.loadingState = false
                    Log.e("2323", "Login Response Items error: ${loginResponse.message}")
                }

                is NetworkResult.Loading -> {
                    profileViewModel.loadingState = false
                }
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
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
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.small),
                    tint = MaterialTheme.colors.selectedBottomBar
                )
            }
        }

        Spacer(modifier = Modifier.height(64.dp))

        Text(
            text = stringResource(id = R.string.set_password_text),
            modifier = Modifier.padding(
                horizontal = MaterialTheme.spacing.semiLarge
            ),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.darkText,
            fontWeight = FontWeight.Bold
        )

        ProfileEditText(
            value = profileViewModel.inputPhoneState,
            onValueChange = {},
            placeHolder = stringResource(id = R.string.phone_and_email)
        )

        ProfileEditText(
            value = profileViewModel.inputPasswordState,
            onValueChange = { profileViewModel.inputPasswordState = it },
            placeHolder = stringResource(id = R.string.set_password)
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

        if(profileViewModel.loadingState){
            ProfileLoadingButton()
        } else {
            ProfileButton(
                text = stringResource(id = R.string.digikala_login),
                onClick = {
                    if (isValidPassword(profileViewModel.inputPasswordState)) {
                        profileViewModel.login()

                    } else {
                        Toast.makeText(
                            context,
                            context.resources.getText(R.string.password_format_error),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            )
        }
    }
}