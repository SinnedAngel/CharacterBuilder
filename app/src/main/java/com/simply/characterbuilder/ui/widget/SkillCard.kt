package com.simply.characterbuilder.ui.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simply.characterbuilder.data.viewparam.Skill
import com.simply.characterbuilder.mock.mockSkill

@Composable
fun SkillCard(skill: Skill, textWidth: Dp = 50.dp) {
    Row {
        Text(
            text = skill.skill.skillName,
            style = MaterialTheme.typography.caption,
            fontSize = 6.sp,
            modifier = Modifier.width(textWidth),
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(4.dp))

        LazyRow {
            val skillBlocks = List<SkillBlock>(skill.skill.maxLevel) { SkillBlock() }
            itemsIndexed(skillBlocks) { index, _ ->
                if (index > 0) {
                    Spacer(modifier = Modifier.width(4.dp))
                }

                val color = when {
                    index <= skill.level -> Color.Yellow.copy(green = 0.6f)
                    else -> Color.DarkGray
                }

                SkillLevelItemView(color, width = 4.dp, height = 6.dp)
            }
        }

        if (skill.level > skill.skill.maxLevel) {
            val skillBlocks = List<SkillBlock>(skill.level - skill.skill.maxLevel) { SkillBlock() }
            LazyRow {
                items(skillBlocks) { _ ->
                    Spacer(modifier = Modifier.width(4.dp))

                    SkillLevelItemView(Color.Red, width = 4.dp, height = 6.dp)
                }
            }
        }
    }
}

class SkillBlock()

@Preview
@Composable
fun PreviewSkillCard() {
    SkillCard(mockSkill("Skill", 3, 7))
}

@Preview
@Composable
fun PreviewSkillCardExceeded() {
    SkillCard(mockSkill("Skill", 8, 7))
}

@Composable
fun SkillLevelItemView(color: Color, width: Dp, height: Dp) {
    Canvas(modifier = Modifier
        .width(width)
        .height(height), onDraw = {
        drawRect(
            color = color,
            topLeft = Offset(x = 0f, y = height.value / 2),
            size = size
        )
    })
}

@Preview
@Composable
fun PreviewSkillLevelItemView() {
    SkillLevelItemView(Color.Yellow, 4.dp, 8.dp)
}