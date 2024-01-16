package com.banice.powermoney.components.charts

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.banice.powermoney.components.charts.BarChartData.Bar
import com.banice.powermoney.models.Recurrence
import com.banice.powermoney.ui.theme.SystemGray04

open class BarDrawer constructor(recurrence: Recurrence) :
   Bar {
    private val barPaint = Paint().apply {
        this.isAntiAlias = true
    }

    private val rightOffset = when(recurrence) {
        Recurrence.Weekly -> 24f
        Recurrence.Monthly -> 6f
        Recurrence.Yearly -> 18f
        else -> 0f
    }

    override fun drawBar(
        drawScope: DrawScope,
        canvas: Canvas,
        barArea: Rect,
        bar: Bar
    ) {
        canvas.drawRoundRect(
            barArea.left,
            0f,
            barArea.right + rightOffset,
            barArea.bottom,
            16f,
            16f,
            barPaint.apply {
                color = SystemGray04
            },
        )
        canvas.drawRoundRect(
            barArea.left,
            barArea.top,
            barArea.right + rightOffset,
            barArea.bottom,
            16f,
            16f,
            barPaint.apply {
                color = bar.color
            },
        )
    }
}