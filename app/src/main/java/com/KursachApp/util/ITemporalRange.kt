package com.KursachApp.util

interface ITemporalRange {

    fun adjustUp(): ITemporalRange

    fun adjustDown(): ITemporalRange
}