package com.kilavuzhilmi.fooddelivery.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kilavuzhilmi.fooddelivery.data.Calories
import com.kilavuzhilmi.fooddelivery.data.NutritionState
import com.kilavuzhilmi.fooddelivery.data.ProductNutritionState
import com.kilavuzhilmi.fooddelivery.ui.theme.AppTheme

@Composable
fun ProductNutritionSection(
    modifier: Modifier = Modifier,
    state: ProductNutritionState
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SectionHeader(title = "Nutrition", calories = state.calories)
        Row(modifier = Modifier.fillMaxWidth()) {
            state.nutrition.onEach { item ->
                NutritionItem(state = item, modifier = Modifier.weight(1f))


            }

        }
    }

}

@Composable
private fun SectionHeader(
    modifier: Modifier = Modifier,
    title: String,
    calories: Calories
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colors.onBackground
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = calories.value,
                style = AppTheme.typography.titleMedium,
                color = AppTheme.colors.onBackground
            )
            Text(
                text = calories.unit,
                style = AppTheme.typography.titleMedium,
                color = AppTheme.colors.onBackground
            )

        }

    }

}

@Composable
private fun NutritionItem(
    modifier: Modifier = Modifier,
    state: NutritionState
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = state.amount,
                style = AppTheme.typography.titleMedium,
                color = AppTheme.colors.onBackground,
                fontWeight = FontWeight.Light
            )
            Text(
                text = state.unit,
                style = AppTheme.typography.titleMedium,
                color = AppTheme.colors.onBackground,
                fontWeight = FontWeight.Light
            )
            Text(
                text = state.title,
                style = AppTheme.typography.label,
                color = AppTheme.colors.onBackground,
            )

        }
    }


}