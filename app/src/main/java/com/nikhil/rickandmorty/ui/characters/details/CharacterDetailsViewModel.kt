package com.nikhil.rickandmorty.ui.characters.details

import androidx.lifecycle.ViewModel
import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto
import com.nikhil.rickandmorty.data.repo.commons.RepoState
import com.nikhil.rickandmorty.domain.characters.details.CharacterDetailsUseCase
import com.nikhil.rickandmorty.domain.characters.list.CharacterListUseCase
import com.nikhil.rickandmorty.ui.characters.list.CharacterListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    val useCase: CharacterDetailsUseCase,
) : ViewModel() {
   sealed class UIState {
       object Loading : UIState()
       data class Success(val data: CharacterDetailsDto) : UIState()
       data class ResponseError(
           val errorState: RepoState,
           val code: Int? = null,
           val message: String? = null
       ) : UIState()
       object Empty : UIState()
       object ServerError : UIState()
       object TokenError : UIState()
       object InternetError : UIState()
   }
    private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)
    val uiState: StateFlow<UIState> = _uiState

}
