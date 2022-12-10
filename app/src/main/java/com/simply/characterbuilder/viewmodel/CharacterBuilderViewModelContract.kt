package com.simply.characterbuilder.viewmodel

import androidx.lifecycle.LiveData
import com.simply.characterbuilder.data.viewparam.ArmorSet
import kotlinx.coroutines.flow.Flow

interface CharacterBuilderViewModelContract {
    val armorSetList: LiveData<MutableList<ArmorSet>>

    fun getArmorSetList()
}