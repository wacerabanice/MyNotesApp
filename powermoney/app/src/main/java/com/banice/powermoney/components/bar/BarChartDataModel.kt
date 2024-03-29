package com.banice.powermoney.components.bar


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale.Companion.Inside
import com.banice.powermoney.components.charts.BarChartData
import com.banice.powermoney.components.charts.DrawLocation
import com.banice.powermoney.components.charts.SimpleValueDrawer


class BarChartDataModel {
    private var colors = mutableListOf(
        Color(0XFFF44336),
        Color(0XFFE91E63),
        Color(0XFF9C27B0),
        Color(0XFF673AB7),
        Color(0XFF3F51B5),
        Color(0XFF03A9F4),
        Color(0XFF009688),
        Color(0XFFCDDC39),
        Color(0XFFFFC107),
        Color(0XFFFF5722),
        Color(0XFF795548),
        Color(0XFF9E9E9E),
        Color(0XFF607D8B)
    )
    var labelDrawer: SimpleValueDrawer by mutableStateOf(SimpleValueDrawer(drawLocation = Inside))
        private set
    var barChartData by mutableStateOf(
        BarChartData(
            bars = listOf(
                BarChartData.Bar(
                    label = "Bar1",
                    value = randomValue(),
                    color = randomColor()
                ),
                BarChartData.Bar(
                    label = "Bar2",
                    value = randomValue(),
                    color = randomColor()
                ),
                BarChartData.Bar(
                    label = "Bar3",
                    value = randomValue(),
                    color = randomColor()
                )
            )
        )
    )

    val bars: List<BarChartData.Bar>
        get() = barChartData.bars
    var labelLocation: DrawLocation = Inside
        set(value) {
            val color = when (value) {
                Inside -> White
                Outside, XAxis -> Black
            }

            labelDrawer = SimpleValueDrawer(
                drawLocation = value,
                labelTextColor = color
            )
            field = value
        }

    fun addBar() {
        barChartData = barChartData
            .copy(bars = bars.toMutableList().apply {
                add(
                    BarChartData.Bar(
                        label = "Bar${bars.size + 1}",
                        value = randomValue(),
                        color = randomColor()
                    )
                )
            })
    }

    fun removeBar() {
        // Remove last.
        barChartData = barChartData.copy(bars = bars.toMutableList().apply {
            val lastBar = bars[bars.size - 1]
            colors.add(lastBar.color)

            remove(lastBar)
        })
    }

    private fun randomValue(): Float = (100 * Math.random() + 25).toFloat()

    private fun randomColor(): Color {
        val randomIndex = (Math.random() * colors.size).toInt()
        val color = colors[randomIndex]
        colors.removeAt(randomIndex)

        return color
    }
}