package com.simply.characterbuilder.data.viewparam

data class ArmorPart(
    val name: String,
    val defense: Int,
    val skills: List<Skill>,
    val decorations: List<DecorationSlot>,
    val part: Part
)
