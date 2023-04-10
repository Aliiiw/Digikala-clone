package com.alirahimi.digikalaclone.ui.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.alirahimi.digikalaclone.data.model.category.SubCategory
import com.alirahimi.digikalaclone.R
import com.alirahimi.digikalaclone.ui.theme.darkText
import com.alirahimi.digikalaclone.ui.theme.grayCategory
import com.alirahimi.digikalaclone.ui.theme.roundedShape
import com.alirahimi.digikalaclone.ui.theme.spacing
import com.alirahimi.digikalaclone.util.DigitHelper.digitByLocate

@Composable
fun SubCategoryItem(item: SubCategory) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .padding(
                vertical = MaterialTheme.spacing.medium,
                horizontal = MaterialTheme.spacing.extraSmall
            ),
        shape = MaterialTheme.roundedShape.small,
        elevation = 1.dp
    ) {
        Column(
            modifier = Modifier
                //.background(MaterialTheme.colors.grayCategory)
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.semiMedium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = rememberAsyncImagePainter(model = item.image),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = item.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "+${digitByLocate(item.count.toString())} ${stringResource(id = R.string.product)}",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
        }
    }
}