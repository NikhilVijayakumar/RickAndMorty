package com.nikhil.rickandmorty.ui.characters.multiple

import androidx.lifecycle.ViewModel
import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto
import com.nikhil.xml.story.annotation.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.reflect.KClass

@HiltViewModel
@UseCase( featureName = "MultiCharacter",
 rootPackageName = "com.nikhil.rickandmorty",
 featurePackageName = "character.multiple",
 dtoClass = CharacterDetailsDto::class)
class MultiCharacterViewModel @Inject constructor(

) : ViewModel() {

}
