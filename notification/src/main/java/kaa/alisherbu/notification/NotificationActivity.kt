package kaa.alisherbu.notification

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.EntryPointAccessors
import kaa.alisherbu.data.GenericViewModelFactory
import kaa.alisherbu.notification.databinding.ActivityNotificationBinding
import kaa.alisherbu.notification.di.DaggerNotificationComponent
import kaa.alisherbu.notification.di.NotificationComponentDependencies
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class NotificationActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityNotificationBinding

    @Inject
    lateinit var viewModelFactory: GenericViewModelFactory<NotificationViewModel>

    private val viewModel: NotificationViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerNotificationComponent.builder()
            .dependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    NotificationComponentDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnGenerateNumber.setOnClickListener {
            viewModel.generateRandomNumber()
        }

        viewBinding.btnDetail.setOnClickListener {
            viewModel.navigateToDetail()
        }

        viewModel.getNotifications()

        viewModel.number.onEach {
            viewBinding.tvNumber.text = it.toString()
        }.launchIn(lifecycleScope)
    }
}