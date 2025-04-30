/*
 * OrderActionBar: Sipariş işlemlerini yönetmek için kullanılan alt çubuk bileşeni
 * Bu bileşen, ürün miktarını ayarlama ve sepete ekleme işlemlerini içerir
 */
package com.kilavuzhilmi.fooddelivery.screens.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kilavuzhilmi.fooddelivery.R
import com.kilavuzhilmi.fooddelivery.data.OrderState
import com.kilavuzhilmi.fooddelivery.ui.theme.AppTheme

/*
 * OrderActionBar: Ana sipariş çubuğu bileşeni
 * @param modifier: Görünüm özelleştirmeleri
 * @param state: Sipariş durumu (miktar ve toplam fiyat)
 * @param onAddItemClicked: + butonuna basıldığında çağrılacak fonksiyon
 * @param onRemoveItemClicked: - butonuna basıldığında çağrılacak fonksiyon
 * @param onCheckOutClicked: Sepete Ekle butonuna basıldığında çağrılacak fonksiyon
 */
@Composable
fun OrderActionBar(
    modifier: Modifier = Modifier,
    state: OrderState,
    onAddItemClicked: () -> Unit,
    onRemoveItemClicked: () -> Unit,
    onCheckOutClicked: () -> Unit
) {
    // Yuvarlak köşeli bir yüzey oluşturur
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        color = AppTheme.colors.surface,
        contentColor = AppTheme.colors.onSurface,
        shadowElevation = 16.dp
    ) {
        // İçeriği yatay olarak düzenler
        Row(
            modifier = Modifier
                .padding(8.dp)
                .height(76.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Miktar seçici (- ve + butonları)
            Selector(
                amount = state.amount,
                onAddItemClicked = onAddItemClicked,
                onRemoveItemClicked = onRemoveItemClicked,
                modifier = Modifier.weight(weight = 1f)
            )
            // Sepete ekleme butonu
            Cart(
                totalPrice = state.totalPrice,
                onClicked = onCheckOutClicked,
                modifier = Modifier.weight(weight = 1f)
            )
        }
    }
}

/*
 * Selector: Ürün miktarını ayarlamak için kullanılan bileşen
 * @param amount: Mevcut ürün miktarı
 * @param onAddItemClicked: Artırma butonu işlevi
 * @param onRemoveItemClicked: Azaltma butonu işlevi
 */
@Composable
private fun Selector(
    modifier: Modifier = Modifier,
    amount: Int,
    onAddItemClicked: () -> Unit,
    onRemoveItemClicked: () -> Unit
) {
    // Kenarlıklı bir kutu oluşturur
    Box(
        modifier = modifier
            .fillMaxSize()
            .border(
                width = 1.dp,
                color = AppTheme.colors.secondarySurface,
                shape = RoundedCornerShape(20.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        // - ve + butonlarını ve miktarı yatayda sıralar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Azaltma butonu (-)
            SelectorButton(
                iconRes = R.drawable.ic_minus,
                containerColor = AppTheme.colors.actionSurface,
                contentColor = AppTheme.colors.onActionSurface,
                onClicked = onRemoveItemClicked
            )
            // Miktar göstergesi
            Text(
                text = amount.toString(),
                color = AppTheme.colors.onSurface,
                style = AppTheme.typography.titleLarge
            )
            // Artırma butonu (+)
            SelectorButton(
                iconRes = R.drawable.ic_plus,
                containerColor = AppTheme.colors.secondarySurface,
                contentColor = AppTheme.colors.onSecondarySurface,
                onClicked = onAddItemClicked
            )
        }
    }
}

/*
 * SelectorButton: Artırma ve azaltma butonlarının tasarımı
 * @param iconRes: Buton ikonu (+ veya -)
 * @param containerColor: Butonun arka plan rengi
 * @param contentColor: İkon rengi
 * @param onClicked: Butona tıklandığında çağrılacak fonksiyon
 */
@Composable
private fun SelectorButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    containerColor: Color,
    contentColor: Color,
    onClicked: () -> Unit
) {
    // Yuvarlak buton yüzeyi
    Surface(
        modifier = modifier.size(24.dp),
        shape = CircleShape,
        color = containerColor,
        contentColor = contentColor
    ) {
        // Tıklanabilir alan
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = onClicked),
            contentAlignment = Alignment.Center
        ) {
            // Buton ikonu
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(7.dp)
            )
        }
    }
}

/*
 * Cart: Sepete ekleme butonu bileşeni
 * @param totalPrice: Toplam fiyat
 * @param onClicked: Butona tıklandığında çağrılacak fonksiyon
 */
@Composable
private fun Cart(
    modifier: Modifier = Modifier,
    totalPrice: String,
    onClicked: () -> Unit
) {
    // Tıklanabilir yuvarlak köşeli yüzey
    Surface(
        modifier = modifier.clickable(onClick = onClicked),
        color = AppTheme.colors.secondarySurface,
        contentColor = AppTheme.colors.onSecondarySurface,
        shape = RoundedCornerShape(20.dp)
    ) {
        // İçeriği ortalayan kutu
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Dikey olarak sıralanmış metin alanları
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // "Sepete Ekle" metni
                Text(
                    text = "Add to Cart",
                    style = AppTheme.typography.titleSmall
                )
                // Toplam fiyat
                Text(
                    text = totalPrice,
                    style = AppTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}