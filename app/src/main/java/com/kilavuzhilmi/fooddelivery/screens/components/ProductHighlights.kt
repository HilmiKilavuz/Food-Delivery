/*
 * ProductHighlights: Ürün özelliklerini gösteren etiketleri içeren bileşen
 * Örneğin: "Bestseller", "Classic Taste" gibi ürün özelliklerini gösteren etiketler
 */
package com.kilavuzhilmi.fooddelivery.screens.components

// Gerekli Jetpack Compose bileşenlerini içe aktarır
import android.R
import android.text.Highlights
import android.view.Surface
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kilavuzhilmi.fooddelivery.data.ProductHighlightState
import com.kilavuzhilmi.fooddelivery.data.ProductHighlightType
import com.kilavuzhilmi.fooddelivery.ui.theme.AppTheme

/*
 * ProductHighlights: Ana bileşen fonksiyonu
 * Bu fonksiyon, ürün etiketlerini dikey bir liste halinde gösterir
 * @param modifier: Bileşenin görünümünü özelleştirmek için kullanılan parametre
 * @param highlights: Gösterilecek etiketlerin listesi
 */
@Composable
fun ProductHighlights(
    modifier: Modifier,
    highlights: List<ProductHighlightState>
) {
    // Dikey bir sütun oluşturur
    Column(
        modifier = modifier,
        // Etiketleri sola hizalar
        horizontalAlignment = Alignment.Start,
        // Etiketler arasında 4dp boşluk bırakır
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // Listedeki her etiketi işler ve ekrana çizer
        highlights.onEach { item ->
            Highlights(
                text = item.text,
                colors = HighlightsDefaults.colors(type = item.type)
            )
        }
    }
}

/*
 * Highlights: Tek bir etiketi oluşturan bileşen
 * @param modifier: Görünüm özelleştirmeleri
 * @param text: Etiketin metni
 * @param colors: Etiketin renk şeması
 */
@Composable
private fun Highlights(
    modifier: Modifier = Modifier,
    text: String,
    colors: HighlightColors = HighlightsDefaults.defaultColor
) {
    // Material Design yüzeyi oluşturur
    androidx.compose.material3.Surface(
        modifier = modifier,
        // Yuvarlak köşeli bir şekil oluşturur (50% = oval)
        shape = RoundedCornerShape(percent = 50),
        // Metin ve arka plan renklerini ayarlar
        contentColor = colors.contentColor,
        color = colors.containerColor
    ) {
        // İçeriği belirli bir padding ile yerleştirir
        Box(modifier = Modifier.padding(vertical = 10.dp, horizontal = 12.dp)) {
            // Etiket metnini kalın yazı tipiyle gösterir
            Text(
                text = text,
                style = AppTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

/*
 * HighlightsDefaults: Etiketlerin varsayılan görünüm ayarlarını içeren nesne
 * Renk şemalarını ve varsayılan değerleri tanımlar
 */
private object HighlightsDefaults {
    // Varsayılan renksiz etiket
    val defaultColor = HighlightColors(
        containerColor = Color.Unspecified,
        contentColor = Color.Unspecified
    )

    // Etiket türüne göre renk seçen fonksiyon
    @Composable
    fun colors(type: ProductHighlightType): HighlightColors = when(type) {
        // PRIMARY: Öne çıkan etiketler için renkler (örn: Bestseller)
        ProductHighlightType.PRIMARY -> HighlightColors(
            containerColor = AppTheme.colors.highlightSurface,
            contentColor = AppTheme.colors.onHighlightSurface
        )
        // SECONDARY: İkincil etiketler için renkler (örn: Classic Taste)
        ProductHighlightType.SECONDARY -> HighlightColors(
            containerColor = AppTheme.colors.actionSurface,
            contentColor = AppTheme.colors.onActionSurface
        )
    }
}

/*
 * HighlightColors: Bir etiketin renklerini tutan veri sınıfı
 * @param containerColor: Etiketin arka plan rengi
 * @param contentColor: Etiketin metin rengi
 */
@Immutable
private data class HighlightColors(
    val containerColor: Color,
    val contentColor: Color
)