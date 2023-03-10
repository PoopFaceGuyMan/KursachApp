package com.KursachApp.util

import com.KursachApp.util.Extensions.Companion.format
import com.KursachApp.util.Extensions.Companion.date
import com.KursachApp.util.Extensions.Companion.toFirstOfLastMonth
import com.KursachApp.util.Extensions.Companion.toLastOfNextMonth
import com.KursachApp.util.Extensions.Companion.toLastOfThisMonth
import com.KursachApp.util.Extensions.Companion.month
import org.junit.Assert
import org.junit.Test
import java.util.*

class ExtensionsTest {

    @Test
    fun testLastOfTheMonth() {
        val date: Date = newDateInstance(2021, 11, 12).toLastOfThisMonth()
        Assert.assertEquals(30, date)
    }

    @Test
    fun testFirstOfLastMonth() {
        val date: Int = newDateInstance(2021, 11, 12)
            .toFirstOfLastMonth()
            .month()
        Assert.assertEquals(9, date)
    }

    @Test
    fun testToFirstOfLastMonth() {
        val date = newDateInstance(2021, 0, 1)
        Assert.assertEquals("2020/12/01", date.toFirstOfLastMonth()
            .format("yyyy/MM/dd"))
    }

    @Test
    fun testToLastOfNextMonth() {
        val date = newDateInstance(2021, 11, 12)
        Assert.assertEquals(31, date.toLastOfNextMonth().date())
    }

    private fun newDateInstance(year: Int, month: Int, date: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DATE, date)
        return calendar.time
    }
}