package com.simply.characterbuilder.data.database

import androidx.room.*
import com.simply.characterbuilder.data.entity.*

@Dao
interface ArmorDao {
    //region Skill
    @Insert
    suspend fun insertSkill(skillItem: SkillItem)

    @Update
    suspend fun updateSkill(skillItem: SkillItem)

    @Delete
    suspend fun deleteSkill(skillItem: SkillItem)

    @Query("SELECT * FROM SkillItem")
    fun getSkills(): List<SkillItem>
    //endregion

    //region Decoration
    @Insert
    suspend fun insertDecoration(decorationItem: DecorationItem)

    @Update
    suspend fun editDecoration(decorationItem: DecorationItem)

    @Delete
    suspend fun deleteDecoration(decorationItem: DecorationItem)

    @Query("SELECT * FROM DecorationItem WHERE level <= :maxLevel")
    fun getDecorations(maxLevel: Int): List<DecorationItem>
    //endregion

    //region Armor
    @Insert
    suspend fun insertArmor(armorPart: ArmorPart)

    @Update
    suspend fun updateArmor(armorPart: ArmorPart)

    @Delete
    suspend fun deleteArmor(armorPart: ArmorPart)

    @Query("SELECT * FROM ArmorPart WHERE part = :part")
    fun getArmors(part: Int): List<ArmorPart>
    //endregion

    //region Armor Set
    @Insert
    suspend fun insertArmorSet(armorSet: ArmorSet)

    @Update
    suspend fun updateArmorSet(armorSet: ArmorSet)

    @Delete
    suspend fun deleteArmorSet(armorSet: ArmorSet)

    @Query("SELECT * FROM ArmorSet")
    fun getArmorSets()
    //endregion

    //region Relations
    @Transaction
    @Query("SELECT * FROM ArmorPart")
    fun getArmorWithSkills(): List<ArmorWithSkill>

    @Transaction
    @Query("SELECT * FROM SkillItem")
    fun getSkillWithArmor(): List<SkillWithArmor>

    @Transaction
    @Query("SELECT * FROM DecorationItem")
    fun getDecorationWithSkills(): List<DecorationWithSkill>

    @Transaction
    @Query("SELECT * FROM SkillItem")
    fun getSkillWithDecoration(): List<SkillWithDecoration>
    //endregion
}