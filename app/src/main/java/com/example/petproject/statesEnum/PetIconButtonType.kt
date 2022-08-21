package com.example.petproject.statesEnum

import com.example.petproject.R

sealed class PetIconButtonType(
    val textButton: String,
    val iconId: Int,
    val iconDescription: String,
    val iconType: PetType
){
    object CatTypeIconButton: PetIconButtonType( "Кошка", R.drawable.cat_icon, "cat", PetType.Cats)
    object DogTypeIconButton: PetIconButtonType( "Собака", R.drawable.dog_icon, "dog", PetType.Dogs)
    object BunnyTypeIconButton: PetIconButtonType( "Другое", R.drawable.bunny_icon, "other", PetType.Other)
}