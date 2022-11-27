package com.example.thirtydays.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dog(
    @StringRes val day: Int,
    @StringRes val breed: Int,
    @DrawableRes val image: Int,
    @StringRes val summary: Int
)