package com.sergiosabater.myfit.model

sealed class DayOfWeek(val ordinal: Int) {
    object Monday : DayOfWeek(1)
    object Tuesday : DayOfWeek(2)
    object Wednesday : DayOfWeek(3)
    object Thursday : DayOfWeek(4)
    object Friday : DayOfWeek(5)
    object Saturday : DayOfWeek(6)
    object Sunday : DayOfWeek(7)
}