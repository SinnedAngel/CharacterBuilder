package com.simply.characterbuilder.ui.widget.armorset

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simply.characterbuilder.data.viewparam.ArmorItem
import com.simply.characterbuilder.data.viewparam.ArmorSet
import com.simply.characterbuilder.data.viewparam.Skill
import com.simply.characterbuilder.mock.mockArmorSet
import com.simply.characterbuilder.ui.widget.SkillCard

@Composable
fun ArmorSetCard(armorSet: ArmorSet) {
    Card(
        modifier = Modifier
            .shadow(4.dp)
            .fillMaxWidth()
    ) {
        var isExpanded by remember {
            mutableStateOf(false)
        }

        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = armorSet.name,
                        style = MaterialTheme.typography.h6
                    )

                    armorSet.head?.let {
                        ArmorPartView(armorItem = it)
                    }
                    ArmorPartView(armorItem = armorSet.body)
                    ArmorPartView(armorItem = armorSet.arm)
                    ArmorPartView(armorItem = armorSet.waist)
                    ArmorPartView(armorItem = armorSet.leg)
                    ArmorPartView(armorItem = armorSet.talisman)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.background,
                            contentColor = Color.Black
                        ),
                        shape = CircleShape,
                        border = BorderStroke(
                            1.5.dp,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .size(40.dp),
                        onClick = { isExpanded = isExpanded.not() }
                    ) {
                        Text(
                            text = if (isExpanded) "-" else "+",
                            fontSize = 15.sp
                        )
                    }
                }
            }

            if (isExpanded) {
                val skills = calculateSkills(armorSet)

                LazyColumn(modifier = Modifier.offset(x = 20.dp)) {
                    items(skills) { skill ->
                        SkillCard(skill = skill)
                    }
                }
            }
        }
    }
}

fun calculateSkills(armorSet: ArmorSet): List<Skill> {
    val skills = mutableListOf<Skill>()

    getSkills(armorSet.head, skills)
    getSkills(armorSet.body, skills)
    getSkills(armorSet.arm, skills)
    getSkills(armorSet.waist, skills)
    getSkills(armorSet.leg, skills)
    getSkills(armorSet.talisman, skills)

    return skills
}

fun getSkills(armor: ArmorItem?, skills: MutableList<Skill>) {
    armor?.run {
        this.armor.skills.forEach {
            val skill = getSkill(it, skills).apply {
                level += it.level
            }
        }

        this.decoration.forEach { deco ->
            deco.skills.forEach {
                val skill = getSkill(it, skills).apply {
                    level += it.level
                }
            }
        }
    }
}

fun getSkill(skill: Skill, skills: MutableList<Skill>): Skill {
    var result = skills.firstOrNull { it.skill.skillName == skill.skill.skillName }

    if (result == null) {
        result = Skill(skill = skill.skill, level = 0)
        skills.add(result)
    }

    return result
}

@Preview
@Composable
fun PreviewArmorSet() {
    ArmorSetCard(mockArmorSet("First"))
}

