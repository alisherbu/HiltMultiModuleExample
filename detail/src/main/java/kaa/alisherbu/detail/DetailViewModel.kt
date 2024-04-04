package kaa.alisherbu.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kaa.alisherbu.data.RandomRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val randomRepository: RandomRepository
) : ViewModel() {

    fun generateNumber() = randomRepository.getRandomNumber()
}