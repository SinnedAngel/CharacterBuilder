package com.simply.characterbuilder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simply.characterbuilder.data.viewparam.ArmorSet
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterBuilderViewModel @Inject constructor(
    private val interactor: CharacterBuilderInteractorContract
) : CharacterBuilderViewModelContract,
    ViewModel() {
    override val armorSetList = MutableLiveData<MutableList<ArmorSet>>()

    override fun getArmorSetList() {
        TODO("Not yet implemented")
    }
}