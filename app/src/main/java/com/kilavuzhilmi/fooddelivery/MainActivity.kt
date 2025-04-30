/*
 * MainActivity: Uygulamanın başlangıç noktası ve ana aktivitesi
 * Bu dosya, uygulamanın ilk açıldığında gösterilen ekranı ve temel mantığını içerir
 */
package com.kilavuzhilmi.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kilavuzhilmi.fooddelivery.data.OrderState
import com.kilavuzhilmi.fooddelivery.screens.ProductDetailsScreen
import com.kilavuzhilmi.fooddelivery.ui.theme.AppTheme

// Ürünün birim fiyatını sabit olarak tanımlıyoruz (5.25$)
private const val PRODUCT_PRICE_PER_UNIT = 5.25
// Para birimi sembolünü sabit olarak tanımlıyoruz ($)
private const val PRODUCT_CURRENCY = "$"

/*
 * MainActivity sınıfı, Android'in temel bileşeni olan ComponentActivity'den türetilmiştir
 * Bu sınıf, uygulamanın ana ekranını ve kullanıcı etkileşimlerini yönetir
 */
class MainActivity : ComponentActivity() {
    /*
     * onCreate: Aktivite başlatıldığında çağrılan ilk fonksiyon
     * Bu fonksiyon içinde uygulamamızın görsel arayüzünü ve mantığını kuruyoruz
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ekranın kenarlarına kadar içeriğin görünmesini sağlar
        enableEdgeToEdge()
        
        // setContent: Jetpack Compose kullanarak arayüzü oluşturur
        setContent {
            // AppTheme: Uygulamamızın görsel temasını (renkler, yazı tipleri vb.) uygular
            AppTheme() {
                // amount: Sepetteki ürün miktarını tutan değişken (başlangıçta 5 adet)
                var amount by remember { mutableIntStateOf(5) }
                
                // totalPrice: Toplam fiyatı hesaplayan değişken (miktar * birim fiyat)
                val totalPrice by remember { derivedStateOf { amount * PRODUCT_PRICE_PER_UNIT } }
                
                // Ana ürün detay ekranını oluşturuyoruz
                ProductDetailsScreen(
                    // + butonuna basıldığında miktarı 1 artır
                    onAddItemClicked = {amount=amount.inc()},
                    // - butonuna basıldığında miktarı 1 azalt (0'dan küçük olamaz)
                    onRemoveItemClicked = {if(amount>0) amount=amount.dec()},
                    // Ödeme butonuna basıldığında yapılacak işlem (şu an boş)
                    onCheckoutClicked = {},
                    // Sipariş durumunu güncelle (miktar ve toplam fiyat)
                    orderState = OrderState(
                        amount = amount,
                        totalPrice = "$PRODUCT_CURRENCY${totalPrice}"
                    )
                )
            }
        }
    }
}


