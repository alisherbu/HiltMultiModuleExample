package kaa.alisherbu.notification.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kaa.alisherbu.notification.domain.NotificationInteractor

@Module
@InstallIn(ViewModelComponent::class)
internal class NotificationModule {

    @Provides
    fun provideNotificationInteractor(): NotificationInteractor {
        return NotificationInteractor()
    }
}