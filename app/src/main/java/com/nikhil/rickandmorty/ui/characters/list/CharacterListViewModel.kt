package com.nikhil.rickandmorty.ui.characters.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.repo.commons.RepoState
import com.nikhil.rickandmorty.domain.characters.list.CharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    val useCase: CharacterListUseCase,
) : ViewModel() {
    sealed class UIState {
        object Loading : UIState()
        data class Success(val data: CharacterListDto) : UIState()
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

    fun getCharacterList() {
        viewModelScope.launch(Dispatchers.IO) {
            val listDtoResponse = useCase()
            withContext(Dispatchers.Main) {
                listDtoResponse.status.also { status ->
                    when (status) {
                        RepoState.SUCCESS -> {
                            _uiState.value = listDtoResponse.data?.let {
                                UIState.Success(it)
                            } ?: UIState.Empty
                        }
                        RepoState.RESPONSE_EMPTY -> {
                            _uiState.value = UIState.Empty
                        }
                        RepoState.RESPONSE_ERROR -> {
                            _uiState.value = UIState.ResponseError(
                                status,
                                listDtoResponse.code,
                                listDtoResponse.message
                            )
                        }
                        RepoState.TOKEN_ERROR -> {
                            _uiState.value = UIState.TokenError
                        }
                        RepoState.SERVER_ERROR -> {
                            _uiState.value = UIState.ServerError
                        }
                        RepoState.INTERNET_ERROR -> {
                            _uiState.value = UIState.InternetError
                        }
                        else -> {
                            _uiState.value = UIState.Empty
                        }
                    }
                }
            }
        }
    }
}
