package com.example.petproject.statesEnum

import com.example.petproject.R

sealed class PetIconButtonType(
    val textButton: String,
    val iconId: Int,
    val iconDescription: String,
    val iconType: IconType
){
    object CatTypeIconButton: PetIconButtonType( "Кошка", R.drawable.cat_icon, "cat", IconType.Cat)
    object DogTypeIconButton: PetIconButtonType( "Собака", R.drawable.dog_icon, "dog", IconType.Dog)
    object BunnyTypeIconButton: PetIconButtonType( "Другое", R.drawable.bunny_icon, "bunny", IconType.Bunny)
}