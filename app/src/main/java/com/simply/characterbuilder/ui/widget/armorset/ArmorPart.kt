package com.simply.characterbuilder.ui.widget.armorset

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simply.characterbuilder.data.viewparam.ArmorItem
import com.simply.characterbuilder.data.viewparam.Part
import com.simply.characterbuilder.mock.mockArmorPart
import com.simply.characterbuilder.mock.mockDecoractionItem

@Composable
fun ArmorPartView(armorItem: ArmorItem?) {
    Row (verticalAlignment = Alignment.CenterVertically){
        armorItem?.let {
            Text(
                text = it.armor.part.code,
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(
                        Color.Gray,
                        shape = CircleShape
                    )
                    .size(15.dp),
                color = MaterialTheme.colors.background,
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = armorItem?.let {
                "${it.armor.name} (${it.armor.defense})"
            } ?: "<EMPTY>",
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview
@Composable
fun PreviewArmorPartView() {
    ArmorPartView(
        ArmorItem(
            mockArmorPart(Part.HEAD),
            listOf(mockDecoractionItem("Deco"))
        )
    )
}

@Preview
@Composable
fun PreviewArmorPartViewEmpty() {
    ArmorPartView(null)
}