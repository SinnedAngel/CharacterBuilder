package com.simply.characterbuilder.di

import android.content.Context
import com.simply.characterbuilder.data.database.AppDatabase
import com.simply.characterbuilder.data.database.ArmorDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getIntance(context)

    @Provides
    fun provideArmorDao(appDatabase: AppDatabase): ArmorDao =
        appDatabase.armorDao()
}