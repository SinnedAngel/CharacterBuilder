package com.simply.characterbuilder.data.datasource

import com.simply.characterbuilder.data.database.ArmorDao
import com.simply.characterbuilder.data.entity.ArmorSet

class ArmorRepository(private val armorDao: ArmorDao) : ArmorDataSource {
    override suspend fun getArmorSetList(): List<ArmorSet> {
        TODO("Not yet implemented")
    }
}