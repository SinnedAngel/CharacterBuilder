package com.simply.characterbuilder.mock

import com.simply.characterbuilder.data.viewparam.*

fun mockArmorSet(name: String) = ArmorSet(
    name = name,
    head = ArmorItem(
        armor = mockArmorPart(Part.HEAD),
        decoration = listOf(mockDecoractionItem(Part.HEAD.name))
    ),
    body = ArmorItem(
        armor = mockArmorPart(Part.BODY),
        decoration = listOf(mockDecoractionItem(Part.BODY.name))
    ),
    arm = ArmorItem(
        armor = mockArmorPart(Part.ARM),
        decoration = listOf(mockDecoractionItem(Part.ARM.name))
    ),
    waist = ArmorItem(
        armor = mockArmorPart(Part.WAIST),
        decoration = listOf(mockDecoractionItem(Part.WAIST.name))
    ),
    leg = ArmorItem(
        armor = mockArmorPart(Part.LEG),
        decoration = listOf(mockDecoractionItem(Part.LEG.name))
    ),
    talisman = ArmorItem(
        armor = mockArmorPart(Part.TALISMAN),
        decoration = listOf(mockDecoractionItem(Part.TALISMAN.name))
    )
)

fun mockArmorPart(part: Part) = ArmorPart(
    name = "$part Armor",
    defense = 1,
    skills = listOf(
        mockSkill("skill 1", 1, 7),
        mockSkill("skill 2", 3, 10),
        mockSkill("skill 3", 1, 20)
    ),
    decorations = listOf(
        DecorationSlot(1),
        DecorationSlot(3, DecorationItem("Deco 2", 2, listOf(mockSkill("Skill 2", 3, 7)))),
        DecorationSlot(3, DecorationItem("Deco 3", 3, listOf(mockSkill("Skill 3", 7, 7))))
    ),
    part = part
)

fun mockSkill(name: String, level: Int, max: Int) = Skill(
    skill = SkillItem(name, max),
    level = level
)

fun mockDecoractionItem(name: String) = DecorationItem(
    name = name,
    level = 1,
    skills = listOf(mockSkill(name, 2, 3))
)