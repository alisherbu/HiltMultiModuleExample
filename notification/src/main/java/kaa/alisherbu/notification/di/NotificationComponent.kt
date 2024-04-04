package kaa.alisherbu.notification.di

import dagger.Component
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kaa.alisherbu.data.RandomRepository
import kaa.alisherbu.notification.NotificationActivity
import kaa.alisherbu.notification.NotificationNavigator

@EntryPoint
@InstallIn(SingletonComponent::class)
interface NotificationComponentDependencies {
    val randomRepository: RandomRepository
    val notificationNavigator: NotificationNavigator
}

@Component(
    dependencies = [NotificationComponentDependencies::class],
    modules = [NotificationModule::class]
)
interface NotificationComponent {

    fun inject(activity: NotificationActivity)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: NotificationComponentDependencies): Builder
        fun build(): NotificationComponent
    }
}