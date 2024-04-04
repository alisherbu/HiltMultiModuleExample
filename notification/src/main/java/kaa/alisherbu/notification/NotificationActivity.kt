package kaa.alisherbu.notification

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kaa.alisherbu.notification.databinding.ActivityNotificationBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class NotificationActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityNotificationBinding
    private val viewModel: NotificationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnGenerateNumber.setOnClickListener {
            viewModel.generateRandomNumber()
        }

        viewBinding.btnDetail.setOnClickListener {
            viewModel.navigateToDetail()
        }

        viewModel.number.onEach {
            viewBinding.tvNumber.text = it.toString()
        }.launchIn(lifecycleScope)
    }
}