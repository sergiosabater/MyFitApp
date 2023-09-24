package com.sergiosabater.myfit.model

sealed class DayOfWeek(val ordinal: Int) {
    object Monday : DayOfWeek(1)
    object Tuesday : DayOfWeek(2)
    object Wednesday : DayOfWeek(3)
    object Thursday : DayOfWeek(4)
    object Friday : DayOfWeek(5)
    object Saturday : DayOfWeek(6)
    object Sunday : DayOfWeek(7)

    companion object {
        fun of(ordinal: Int): DayOfWeek {
            return when (ordinal) {
                1 -> Monday
                2 -> Tuesday
                3 -> Wednesday
                4 -> Thursday
                5 -> Friday
                6 -> Saturday
                7 -> Sunday
                else -> throw IllegalArgumentException("Invalid ordinal for DayOfWeek: $ordinal")
            }
        }
    }
}