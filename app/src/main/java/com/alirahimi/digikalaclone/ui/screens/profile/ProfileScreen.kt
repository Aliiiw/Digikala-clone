package com.alirahimi.digikalaclone.ui.screens.profile


import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.viewmodel.DataStoreViewModel
import com.alirahimi.digikalaclone.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

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

@Composable
fun Profile() {
    Text(text = "Profile")
}