package kaa.alisherbu.notification

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kaa.alisherbu.data.RandomRepository
import kaa.alisherbu.notification.domain.NotificationInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
internal class NotificationViewModel @Inject constructor(
    private val randomRepository: RandomRepository,
    private val navigator: NotificationNavigator,
    private val notificationInteractor: NotificationInteractor
) : ViewModel() {
    private val _number = MutableStateFlow<Int?>(null)
    val number = _number.asStateFlow()

    fun generateRandomNumber() {
        _number.value = randomRepository.getRandomNumber()
    }

    fun navigateToDetail() {
        navigator.navigateToDetail()
    }

    fun getNotifications(){
        notificationInteractor.getNotifications()
    }
}