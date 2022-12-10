package com.simply.characterbuilder.viewmodel

import com.simply.characterbuilder.data.datasource.ArmorDataSource
import com.simply.characterbuilder.data.viewparam.ArmorSet

class CharacterBuilderInteractor(private val dataSource: ArmorDataSource) :
    CharacterBuilderInteractorContract {
    override suspend fun getArmorSetList(): List<ArmorSet> {
        TODO("Not yet implemented")
    }
}