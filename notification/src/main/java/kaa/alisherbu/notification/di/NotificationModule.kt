package kaa.alisherbu.notification.di

import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import kaa.alisherbu.notification.domain.NotificationInteractor

@Module
@DisableInstallInCheck
internal class NotificationModule {

    @Provides
    fun provideNotificationInteractor(): NotificationInteractor {
        return NotificationInteractor()
    }
}