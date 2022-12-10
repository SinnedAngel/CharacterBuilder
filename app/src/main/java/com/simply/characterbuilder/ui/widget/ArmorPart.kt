package com.simply.characterbuilder.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simply.characterbuilder.data.viewparam.ArmorItem
import com.simply.characterbuilder.data.viewparam.Part
import com.simply.characterbuilder.mock.mockArmorPart
import com.simply.characterbuilder.mock.mockDecoractionItem

@Composable
fun ArmorItemCard(armor: ArmorItem) {
    Card(
        modifier = Modifier
            .shadow(4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = armor.armor.part.toString(),
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color.Gray),
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.background
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Row(
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = armor.armor.name,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = "Defense = ${armor.armor.defense}",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }

                LazyColumn {
                    items(armor.armor.skills) { skill ->
                        SkillCard(skill = skill)
                    }
                }

                val slots = mutableListOf<Slot>()

                armor.armor.decorations.forEachIndexed { index, decoration ->
                    slots.add(Slot(decoration.level, decoration.decorationItem?.level ?: 0))
                }

                LazyRow {
                    items(slots) { slot ->
                        DecorationSlotView(
                            level = slot.level,
                            slot.fill,
                            width = 15.dp,
                            height = 15.dp
                        )
                    }
                }
            }
        }
    }
}

data class Slot(val level: Int, val fill: Int)

@Preview
@Composable
fun PreviewArmorItemCard() {
    ArmorItemCard(
        ArmorItem(
            armor = mockArmorPart(Part.HEAD),
            decoration = listOf(mockDecoractionItem(Part.HEAD.toString()))
        )
    )
}