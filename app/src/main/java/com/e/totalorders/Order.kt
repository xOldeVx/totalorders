package com.e.totalorders

import java.time.LocalDateTime

class Order(internal var orderId: Int, creationDate: LocalDateTime, orderLine: List<OrderLine>) {
    var creationDate: LocalDateTime
        internal set
    var orderLine: List<OrderLine>
        internal set

    init {
        this.creationDate = creationDate
        this.orderLine = orderLine
    }
}
