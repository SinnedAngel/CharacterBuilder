package com.simply.characterbuilder.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["decoration_id", "skill_id"])
data class DecorationSkill(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "decoration_id") val decotrationId: Int,
    @ColumnInfo(name = "skill_id") val skillId: Int,
    @ColumnInfo(name = "level") val level: Int
)
