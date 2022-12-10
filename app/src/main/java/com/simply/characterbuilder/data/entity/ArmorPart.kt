package com.simply.characterbuilder.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArmorPart(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "defense") val defense: Int,
    @ColumnInfo(name = "part") val part: Int
)
