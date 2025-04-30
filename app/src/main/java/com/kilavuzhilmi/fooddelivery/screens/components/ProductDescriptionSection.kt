package com.kilavuzhilmi.fooddelivery.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kilavuzhilmi.fooddelivery.ui.theme.AppTheme

@Composable
fun ProductDescriptionSection(
    modifier: Modifier = Modifier,
    productDescription: String
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(20.dp).padding(bottom = 130.dp),
        verticalArrangement = Arrangement.spacedBy(11.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Description",
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colors.onBackground
        )
        Text(
            text = productDescription,
            style = AppTheme.typography.body,
            color = AppTheme.colors.onBackground,
            textAlign = TextAlign.Justify,
            modifier= Modifier.fillMaxWidth()
        )

    }

}