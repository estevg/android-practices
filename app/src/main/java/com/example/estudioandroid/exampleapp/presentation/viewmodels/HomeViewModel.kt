package com.example.estudioandroid.exampleapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.estudioandroid.exampleapp.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCharactersUseCase: GetCharactersUseCase) :
    ViewModel() {


}