package com.simply.characterbuilder.viewmodel

import com.simply.characterbuilder.data.viewparam.ArmorSet
import kotlinx.coroutines.flow.Flow

interface CharacterBuilderInteractorContract {
    suspend fun getArmorSetList(): List<ArmorSet>
}