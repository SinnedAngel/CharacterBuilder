package com.simply.characterbuilder.data.datasource

import com.simply.characterbuilder.data.entity.ArmorSet

interface ArmorDataSource {
    suspend fun getArmorSetList(): List<ArmorSet>
}