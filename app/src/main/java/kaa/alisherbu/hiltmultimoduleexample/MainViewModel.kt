package kaa.alisherbu.hiltmultimoduleexample

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kaa.alisherbu.data.RandomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val randomRepository: RandomRepository
) : ViewModel() {
    private val _number = MutableStateFlow<Int?>(null)
    val number: StateFlow<Int?> = _number.asStateFlow()

    fun generateRandomNumber() {
        _number.value = randomRepository.getRandomNumber()
    }
}