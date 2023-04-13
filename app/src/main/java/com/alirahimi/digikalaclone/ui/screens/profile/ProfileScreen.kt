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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alirahimi.digikalaclone.viewmodel.DataStoreViewModel
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.ui.theme.*

@Composable
fun ProfileScreen(
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel()
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
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
        }

        item {
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
        }

        item {
            Image(
                painter = painterResource(id = R.drawable.digi_smile),
                contentDescription = "",
                modifier = Modifier.size(200.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
        }

        item {
            Text(
                text = stringResource(id = R.string.loginTxt),
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.darkText,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    horizontal = MaterialTheme.spacing.semiLarge
                )
            )
        }

        item {
            ProfileEditText(
                value = "",
                onValueChange = {},
                placeHolder = stringResource(id = R.string.phone_and_email)
            )
        }

        item {
            ProfileButton(
                text = stringResource(id = R.string.digikala_entry),
                onClick = {}
            )
        }

        item {
            Divider(
                color = MaterialTheme.colors.searchBarBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp)
                    .padding(top = MaterialTheme.spacing.medium)
            )
        }

        item {
            TermsAndRulesText(
                fullText = stringResource(id = R.string.terms_and_rules_full),
                underLinedTexts = listOf(
                    stringResource(id = R.string.terms_and_rules),
                    stringResource(id = R.string.privacy_and_rules)
                ),
                textColor = MaterialTheme.colors.semiDarkText,
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}