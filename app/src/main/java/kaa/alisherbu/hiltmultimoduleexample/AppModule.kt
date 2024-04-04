package kaa.alisherbu.hiltmultimoduleexample

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kaa.alisherbu.data.RandomRepository
import kaa.alisherbu.hiltmultimoduleexample.navigator.NotificationNavigatorImpl
import kaa.alisherbu.notification.NotificationNavigator

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindNotificationNavigator(impl: NotificationNavigatorImpl): NotificationNavigator

    companion object {
        @Provides
        fun provideRandomRepository(): RandomRepository {
            return RandomRepository()
        }
    }
}