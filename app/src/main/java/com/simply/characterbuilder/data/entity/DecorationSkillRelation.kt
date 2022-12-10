package com.simply.characterbuilder.data.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class DecorationWithSkill(
    @Embedded
    val armor: DecorationItem,
    @Relation(
        parentColumn = "uid",
        entityColumn = "uid",
        associateBy = Junction(DecorationItem::class)
    )
    val skills: List<SkillItem>
)

data class SkillWithDecoration(
    @Embedded
    val skill: SkillItem,
    @Relation(
        parentColumn = "uid",
        entityColumn = "uid",
        associateBy = Junction(SkillItem::class)
    )
    val armors: List<DecorationItem>
)