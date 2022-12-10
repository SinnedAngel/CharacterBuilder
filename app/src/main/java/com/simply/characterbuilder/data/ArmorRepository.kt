package com.simply.characterbuilder.data

import com.simply.characterbuilder.data.database.ArmorDao
import javax.inject.Inject

class ArmorRepository @Inject constructor(private val dao: ArmorDao) {
}