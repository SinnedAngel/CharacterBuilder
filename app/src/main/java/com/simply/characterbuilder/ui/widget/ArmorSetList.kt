package com.simply.characterbuilder.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.simply.characterbuilder.data.viewparam.ArmorSet
import com.simply.characterbuilder.mock.mockArmorSet
import com.simply.characterbuilder.ui.widget.armorset.ArmorSetCard
import com.simply.characterbuilder.viewmodel.CharacterBuilderViewModel

@Composable
fun ArmorSetListFragment(
    armorSetList: List<ArmorSet>
) {
   if (armorSetList.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(armorSetList) { index, armorSet ->
                if (index > 0) {
                    Spacer(modifier = Modifier.height(4.dp))
                }

                ArmorSetCard(armorSet = armorSet)
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "No armor set found.",
                textAlign = TextAlign.Center,
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Create new armor set")
            }
        }
    }
}

@Preview
@Composable
fun PreviewArmorSetListFragment() {
    ArmorSetListFragment(
        armorSetList = listOf(
            mockArmorSet("Armor Set 1"),
            mockArmorSet("Armor Set 2")
        )
    )
}

@Preview
@Composable
fun PreviewArmorSetListFragmentEmpty() {
    ArmorSetListFragment(
        armorSetList = emptyList()
    )
}