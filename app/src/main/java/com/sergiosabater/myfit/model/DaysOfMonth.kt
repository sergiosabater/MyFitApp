package com.sergiosabater.myfit.model

data class DaysOfMonth(val value: Int) {
    init {
        require(value in 28..31) { "A month can only have between 28 and 31 days!" }
    }
}