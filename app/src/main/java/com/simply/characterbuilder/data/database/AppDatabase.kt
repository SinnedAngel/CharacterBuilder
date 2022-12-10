package com.simply.characterbuilder.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.simply.characterbuilder.data.entity.*

@Database(
    entities = [SkillItem::class, ArmorPart::class, DecorationItem::class, ArmorSet::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "character_builder"

        @Volatile
        private var instace: AppDatabase? = null

        fun getIntance(context: Context): AppDatabase {
            return instace ?: synchronized(this) {
                instace ?: buildDatabase(context).also { instace = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
        }
    }

    abstract fun armorDao(): ArmorDao
}