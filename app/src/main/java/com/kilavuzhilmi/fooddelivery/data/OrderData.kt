/*
 * OrderData: Sipariş bilgilerini içeren veri yapılarını tanımlayan dosya
 * Bu dosya, sipariş miktarı ve toplam fiyat gibi temel sipariş bilgilerini yönetir
 */
package com.kilavuzhilmi.fooddelivery.data

/*
 * OrderState: Sipariş durumunu temsil eden veri sınıfı
 * 
 * @param amount: Sipariş edilen ürün miktarı
 * @param totalPrice: Toplam fiyat (para birimi sembolü ile birlikte)
 * 
 * Örnek kullanım:
 * OrderState(amount = 2, totalPrice = "$10.50")
 */
data class OrderState(
    val amount: Int,
    val totalPrice: String
)

/*
 * OrderData: Varsayılan sipariş durumu
 * 
 * Başlangıç değerleri:
 * - Miktar: 5 adet
 * - Toplam Fiyat: 27.45$
 * 
 * Not: Bu sabit değerler genellikle test veya örnek amaçlı kullanılır
 */
val OrderData = OrderState(
    amount = 5,
    totalPrice = "27.45$"
)