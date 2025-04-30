/*
 * ProductPreviewData: Ürün önizleme ekranında kullanılan veri yapılarını içeren dosya
 * Bu dosya, ürünlerin etiketlerini ve önizleme bilgilerini tanımlar
 */
package com.kilavuzhilmi.fooddelivery.data

import androidx.annotation.DrawableRes
import com.kilavuzhilmi.fooddelivery.R

/*
 * ProductHighlightState: Ürün etiketi veri sınıfı
 * Örnek kullanım:
 * - "Bestseller" etiketi (PRIMARY tip, sarı renk)
 * - "Classic Taste" etiketi (SECONDARY tip, gri renk)
 *
 * @param text: Etiketin üzerinde gösterilecek metin
 * @param type: Etiketin türü (PRIMARY veya SECONDARY)
 */
data class ProductHighlightState(
    val text: String,
    val type: ProductHighlightType
)

/*
 * ProductHighlightType: Etiket türlerini tanımlayan enum sınıfı
 * 
 * PRIMARY: Öne çıkan özellikler için kullanılır (örn: "Bestseller")
 *         - Genellikle dikkat çekici renklerle gösterilir (sarı, yeşil vb.)
 * 
 * SECONDARY: İkincil özellikler için kullanılır (örn: "Classic Taste")
 *           - Genellikle daha nötr renklerle gösterilir (gri, açık renkler)
 */
enum class ProductHighlightType {
    PRIMARY, SECONDARY
}

/*
 * ProductPreviewState: Ürün önizleme ekranında gösterilecek tüm bilgileri içeren veri sınıfı
 *
 * @param headline: Ürünün başlığı (varsayılan: "Mr. Cheezy")
 * @param productImage: Ürün fotoğrafının kaynak ID'si
 * @param highlights: Ürünün etiketlerinin listesi
 *
 * Varsayılan olarak:
 * - Başlık: "Mr. Cheezy"
 * - Resim: Burger görseli
 * - Etiketler: 
 *   1. "Classic Taste" (SECONDARY tip)
 *   2. "Bestseller" (PRIMARY tip)
 */
data class ProductPreviewState(
    val headline: String = "Mr. Cheezy",
    @DrawableRes val productImage: Int = R.drawable.img_burger,
    val highlights: List<ProductHighlightState> = listOf(
        ProductHighlightState(
            text = "Classic Taste",
            type = ProductHighlightType.SECONDARY
        ),
        ProductHighlightState(
            text = "Bestseller",
            type = ProductHighlightType.PRIMARY
        )
    )
)