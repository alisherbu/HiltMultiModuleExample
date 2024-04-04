package kaa.alisherbu.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class GenericViewModelFactory<T : ViewModel> @Inject constructor(
    private val provider: Provider<T>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return provider.get() as T
    }
}