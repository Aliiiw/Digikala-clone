package com.alirahimi.digikalaclone.ui.screens.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.alirahimi.digikalaclone.data.model.category.CategoryResponse
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.data.model.category.SubCategory
import com.alirahimi.digikalaclone.ui.theme.lightCyan

@Composable
fun CategoryItem(
    title: String,
    subList: List<SubCategory>
) {

    Row(
        Modifier
            .fillMaxWidth()
            .padding(
                top = MaterialTheme.spacing.medium,
                bottom = MaterialTheme.spacing.small,
                start = MaterialTheme.spacing.small,
                end = MaterialTheme.spacing.small
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium),
            text = stringResource(id = R.string.see_all),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.lightCyan
        )
    }

    LazyRow(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.extraSmall)) {
        items(subList) { list ->
            SubCategoryItem(item = list)
        }
    }
}