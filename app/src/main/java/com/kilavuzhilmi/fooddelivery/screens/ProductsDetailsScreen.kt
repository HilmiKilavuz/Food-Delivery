// Bu dosya, ürün detay sayfasının ana ekranını oluşturur
package com.kilavuzhilmi.fooddelivery.screens

// Gerekli Jetpack Compose bileşenlerini içe aktarır
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kilavuzhilmi.fooddelivery.data.OrderData
import com.kilavuzhilmi.fooddelivery.data.OrderState
import com.kilavuzhilmi.fooddelivery.data.ProductDescriptionData
import com.kilavuzhilmi.fooddelivery.data.ProductFlavorState
import com.kilavuzhilmi.fooddelivery.data.ProductFlavorsData
import com.kilavuzhilmi.fooddelivery.data.ProductNutritionData
import com.kilavuzhilmi.fooddelivery.data.ProductNutritionState
import com.kilavuzhilmi.fooddelivery.data.ProductPreviewState
import com.kilavuzhilmi.fooddelivery.screens.components.FlavorSection
import com.kilavuzhilmi.fooddelivery.screens.components.OrderActionBar
import com.kilavuzhilmi.fooddelivery.screens.components.ProductDescriptionSection
import com.kilavuzhilmi.fooddelivery.screens.components.ProductNutritionSection
import com.kilavuzhilmi.fooddelivery.screens.components.ProductPreviewSection

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState = ProductPreviewState(),
    productFlavors: List<ProductFlavorState> = ProductFlavorsData,
    productNutritionState: ProductNutritionState = ProductNutritionData,
    productDescription: String = ProductDescriptionData,
    orderState: OrderState = OrderData,
    onAddItemClicked: () -> Unit = {},
    onRemoveItemClicked: () -> Unit = {},
    onCheckOutClicked: () -> Unit = {},
    onCheckoutClicked: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Content(
            productDescription = productDescription,
            productFlavors = productFlavors,
            productNutritionState = productNutritionState,
            productPreviewState = productPreviewState,
        )
        OrderActionBar(
            state = orderState,
            onAddItemClicked = onAddItemClicked,
            onRemoveItemClicked = onRemoveItemClicked,
            onCheckOutClicked = onCheckOutClicked,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(
                    horizontal = 18.dp,
                    vertical = 8.dp
                )
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState,
    productFlavors: List<ProductFlavorState>,
    productNutritionState: ProductNutritionState,
    productDescription: String
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollState)
    ) {
        ProductPreviewSection(
            state = productPreviewState
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        FlavorSection(
            data = productFlavors,
            modifier = Modifier.padding(horizontal = 18.dp)
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        ProductNutritionSection(
            state = productNutritionState,
            modifier = Modifier.padding(horizontal = 18.dp)
        )
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        ProductDescriptionSection(
            productDescription = productDescription,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(horizontal = 18.dp)
                .padding(bottom = 128.dp)
        )
    }
}