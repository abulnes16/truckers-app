package com.abulnes.trucker_app.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Spacing {
    val xxsm: Dp= 4.dp
    val xsm: Dp = 8.dp
    val sm: Dp = 10.dp
    val md: Dp = 12.dp
    val normal: Dp = 16.dp
    val lg: Dp = 18.dp
    val xl: Dp = 24.dp
    val xxl: Dp = 32.dp
    val xxxl: Dp = 36.dp
    val custom: (spacing: Int)-> Dp = {measure -> measure.dp}
}