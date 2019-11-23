package com.e.totalorders

class OrderLine(internal var productId: Int, quantity: Int, internal var name: String, internal var unitPrice: Double) {
    var quantity: Int = 0
        internal set

    init {
        this.quantity = quantity
    }
}
