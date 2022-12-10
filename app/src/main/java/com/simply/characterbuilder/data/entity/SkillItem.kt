package com.simply.characterbuilder.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SkillItem(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "skill_name") val skillName: String,
    @ColumnInfo(name = "max_level") val maxLevel: Int
)
