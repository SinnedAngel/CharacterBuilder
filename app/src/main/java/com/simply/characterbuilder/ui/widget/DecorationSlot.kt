package com.simply.characterbuilder.ui.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun DecorationSlotView(level: Int, fill: Int, width: Dp, height: Dp) {
    val points = mutableListOf<Offset>()

    val sides = level + 2

    for (n in 0..sides) {
        val theta = 2 * Math.PI / sides
        points.add(
            Offset(
                x = (width.value * cos(theta * n.toFloat()).toFloat()) + (width.value) + (width.value / 3),
                y = (height.value * sin(theta * n.toFloat()).toFloat()) + (height.value) + (height.value / 3)
            )
        )
    }

    Box(contentAlignment = Alignment.Center) {
        Canvas(
            modifier = Modifier
                .width(width)
                .height(height)
                .padding(0.dp),
            onDraw = {
                withTransform({ rotate(degrees = 90f) }) {
                    drawPath(
                        color = when {
                            fill == 0 -> Color.Gray
                            fill < level -> Color.Yellow
                            else -> Color.Green
                        },
                        path = Path().apply {
                            points.forEachIndexed { index, offset ->
                                if (index == 0) {
                                    moveTo(offset.x, offset.y)
                                } else {
                                    lineTo(offset.x, offset.y)
                                }
                            }
                        }
                    )

                    drawPoints(
                        color = Color.DarkGray,
                        pointMode = PointMode.Polygon,
                        points = points
                    )
                }
            }
        )

        if (fill > 0) {
            Text(
                text = fill.toString(),
                fontSize = (height.value / 3).sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewDecorationSlotViewLv1() {
    DecorationSlotView(1, 0, 50.dp, 50.dp)
}

@Preview
@Composable
fun PreviewDecorationSlotViewLv2() {
    DecorationSlotView(2, 1, 50.dp, 50.dp)
}

@Preview
@Composable
fun PreviewDecorationSlotViewLv3() {
    DecorationSlotView(3, 3, 50.dp, 50.dp)
}

@Preview
@Composable
fun PreviewDecorationSlotViewLv4() {
    DecorationSlotView(4, 0, 50.dp, 50.dp)
}