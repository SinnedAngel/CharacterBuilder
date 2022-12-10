package com.simply.characterbuilder.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ArmorSet(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "headArmor") var headArmor: Int,
    @ColumnInfo(name = "headDecorations") var headDecorations: String, //Name list
    @ColumnInfo(name = "bodyArmor") var bodyArmor: Int,
    @ColumnInfo(name = "bodyDecorations") var bodyDecorations: String, //Name list
    @ColumnInfo(name = "armArmor") var armArmor: Int,
    @ColumnInfo(name = "armDecorations") var armDecorations: String, //Name list
    @ColumnInfo(name = "waistArmor") var waistArmor: Int,
    @ColumnInfo(name = "waistDecorations") var waistDecorations: String, //Name list
    @ColumnInfo(name = "legArmor") var legArmor: Int,
    @ColumnInfo(name = "legDecorations") var legDecorations: String, //Name list
    @ColumnInfo(name = "talisman") var talisman: Int,
    @ColumnInfo(name = "talismanDecorations") var talismanDecorations: String //Name list
)
