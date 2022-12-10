package com.simply.characterbuilder.data.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ArmorWithSkill(
    @Embedded
    val armor: ArmorPart,
    @Relation(
        parentColumn = "uid",
        entityColumn = "uid",
        associateBy = Junction(ArmorSkill::class)
    )
    val skills: List<SkillItem>
)

data class SkillWithArmor(
    @Embedded
    val skill: SkillItem,
    @Relation(
        parentColumn = "uid",
        entityColumn = "uid",
        associateBy = Junction(SkillItem::class)
    )
    val armors: List<ArmorPart>
)