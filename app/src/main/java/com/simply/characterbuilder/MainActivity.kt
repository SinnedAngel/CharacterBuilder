package com.simply.characterbuilder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.simply.characterbuilder.data.viewparam.ArmorSet
import com.simply.characterbuilder.ui.theme.CharacterBuilderTheme
import com.simply.characterbuilder.ui.widget.ArmorSetListFragment
import com.simply.characterbuilder.viewmodel.CharacterBuilderViewModelContract
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel : CharacterBuilderViewModelContract by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharacterBuilderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val armorSetList: MutableList<ArmorSet> by viewModel.armorSetList.observeAsState()

                    ArmorSetListFragment(emptyList())
                }
            }
        }
    }
}