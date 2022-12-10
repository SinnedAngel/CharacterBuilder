package com.simply.characterbuilder.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["armor_id", "skill_id"])
data class ArmorSkill(
    @ColumnInfo(name = "armor_id") val armorId: Long,
    @ColumnInfo(name = "skill_id") val skillId: Long,
    @ColumnInfo(name = "level") val level: Int
)
