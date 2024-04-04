package kaa.alisherbu.hiltmultimoduleexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kaa.alisherbu.hiltmultimoduleexample.databinding.ActivityMainBinding
import kaa.alisherbu.notification.NotificationActivity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.btnNotification.setOnClickListener {
            startActivity(Intent(this@MainActivity, NotificationActivity::class.java))
        }

        viewBinding.btnGenerateNumber.setOnClickListener {
            viewModel.generateRandomNumber()
        }

        viewModel.number.onEach {
            viewBinding.tvNumber.text = it.toString()
        }.launchIn(lifecycleScope)
    }
}
