package kaa.alisherbu.hiltmultimoduleexample.navigator

import android.content.Context
import android.content.Intent
import dagger.hilt.android.qualifiers.ApplicationContext
import kaa.alisherbu.detail.DetailActivity
import kaa.alisherbu.notification.NotificationNavigator
import javax.inject.Inject

class NotificationNavigatorImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : NotificationNavigator {
    override fun navigateToDetail() {
        val intent = Intent(context, DetailActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intent)
    }
}