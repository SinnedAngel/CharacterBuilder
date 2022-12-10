package com.simply.characterbuilder.di

import com.simply.characterbuilder.data.database.ArmorDao
import com.simply.characterbuilder.data.datasource.ArmorDataSource
import com.simply.characterbuilder.data.datasource.ArmorRepository
import com.simply.characterbuilder.viewmodel.CharacterBuilderInteractor
import com.simply.characterbuilder.viewmodel.CharacterBuilderInteractorContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class CharacterBuilderModule {
    @Provides
    fun provideArmorDataSource(armorDao: ArmorDao): ArmorDataSource =
        ArmorRepository(armorDao)

    @Provides
    fun provideArmorSetInteractor(dataSource: ArmorDataSource): CharacterBuilderInteractorContract =
        CharacterBuilderInteractor(dataSource)
}