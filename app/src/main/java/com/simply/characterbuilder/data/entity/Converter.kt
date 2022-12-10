package com.simply.characterbuilder.data.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun saveSkills(skills: List<ArmorSkill>): String {
        val type = object : TypeToken<List<ArmorSkill>>() {}.type
        return Gson().toJson(skills, type)
    }

    @TypeConverter
    fun loadSkills(skills: String): List<ArmorSkill> {
        val type = object : TypeToken<List<ArmorSkill>>() {}.type
        return Gson().fromJson(skills, type)
    }
}