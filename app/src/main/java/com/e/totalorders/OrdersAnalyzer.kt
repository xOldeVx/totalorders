package com.e.totalorders

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.ArrayList
import java.util.HashMap

import java.time.DayOfWeek.FRIDAY
import java.time.DayOfWeek.MONDAY
import java.time.DayOfWeek.SATURDAY
import java.time.DayOfWeek.SUNDAY
import java.time.DayOfWeek.THURSDAY
import java.time.DayOfWeek.TUESDAY
import java.time.DayOfWeek.WEDNESDAY

class OrdersAnalyzer : AppCompatActivity() {

    internal var map: MutableMap<DayOfWeek, Int> = HashMap()
    internal var orderLines: MutableList<OrderLine> = ArrayList()
    internal var orderList: MutableList<Order> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sunday Order
        orderLines.add(OrderLine(9872, 4, "Pencil", 3.12))
        orderLines.add(OrderLine(4098, 5, "Marker", 4.50))
        orderList.add(Order(690, LocalDateTime.of(2017, 3, 26, 11, 14, 0), orderLines))
        orderLines = ArrayList()

        // Monday Order
        orderLines.add(OrderLine(5723, 4, "Pen", 4.22))
        orderLines.add(OrderLine(9872, 3, "Pencil", 3.12))
        orderLines.add(OrderLine(3433, 1, "Erasers Set", 6.15))
        orderList.add(Order(453, LocalDateTime.of(2017, 3, 27, 14, 53, 12), orderLines))
        orderLines = ArrayList()

        orderLines.add(OrderLine(5723, 7, "Pen", 4.22))
        orderLines.add(OrderLine(3433, 2, "Erasers Set", 6.15))
        orderList.add(Order(431, LocalDateTime.of(2017, 3, 20, 12, 15, 2), orderLines))
        orderLines = ArrayList()

        // Saturday Order
        orderLines.add(OrderLine(9872, 3, "Pencil", 3.00))
        orderList.add(Order(554, LocalDateTime.of(2017, 3, 25, 10, 35, 20), orderLines))
        orderLines = ArrayList()

        orderLines.add(OrderLine(9872, 2, "Pencil", 3.00))
        orderLines.add(OrderLine(1746, 1, "Eraser", 1.00))
        orderList.add(Order(555, LocalDateTime.of(2017, 3, 25, 11, 24, 20), orderLines))

        val tvResult = findViewById<TextView>(R.id.tvResult)
        tvResult.text = "" + totalDailySales(orderList)
    }


    internal fun totalDailySales(order: List<Order>): Map<DayOfWeek, Int> {
        var sundayTotal = 0
        var mondayTotal = 0
        var tuesdayTotal = 0
        var wednesdayTotal = 0
        var thursdayTotal = 0
        var fridayTotal = 0
        var saturdayTotal = 0

        for (i in order.indices) {
            when (order[i].creationDate.dayOfWeek) {
                SUNDAY -> {
                    orderLines = order[i].orderLine
                    for (j in orderLines.indices) {
                        sundayTotal += orderLines[j].quantity
                    }
                    map[SUNDAY] = sundayTotal
                }
                MONDAY -> {
                    orderLines = order[i].orderLine
                    for (j in orderLines.indices) {
                        mondayTotal += orderLines[j].quantity
                    }
                    map[MONDAY] = mondayTotal
                }
                TUESDAY -> {
                    orderLines = order[i].orderLine
                    for (j in orderLines.indices) {
                        tuesdayTotal += orderLines[j].quantity
                    }
                    map[TUESDAY] = tuesdayTotal
                }
                WEDNESDAY -> {
                    orderLines = order[i].orderLine
                    for (j in orderLines.indices) {
                        wednesdayTotal += orderLines[j].quantity
                    }
                    map[WEDNESDAY] = wednesdayTotal
                }
                THURSDAY -> {
                    orderLines = order[i].orderLine
                    for (j in orderLines.indices) {
                        thursdayTotal += orderLines[j].quantity
                    }
                    map[THURSDAY] = thursdayTotal
                }
                FRIDAY -> {
                    orderLines = order[i].orderLine
                    for (j in orderLines.indices) {
                        fridayTotal += orderLines[j].quantity
                    }
                    map[FRIDAY] = fridayTotal
                }
                SATURDAY -> {
                    orderLines = order[i].orderLine
                    for (j in orderLines.indices) {
                        saturdayTotal += orderLines[j].quantity
                    }
                    map[SATURDAY] = saturdayTotal
                }
            }
        }
        return map
    }
}
