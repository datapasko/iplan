package com.tapascodev.iplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.tapascodev.iplan.auth.ui.AuthActivity
import com.tapascodev.iplan.base.ui.startNewActivity
import com.tapascodev.iplan.databinding.ActivityMainBinding
import com.tapascodev.iplan.home.ui.HomeActivity
import com.tapascodev.iplan.storage.data.UserPreferences
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var preferences: UserPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        screenSplash.setKeepOnScreenCondition { false }
        validateToken()
    }
    private fun validateToken() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                preferences.accessToken.collect{ token ->
                    val activity = if (token == null) AuthActivity::class.java else HomeActivity::class.java
                    startNewActivity(activity)
                    finish()
                }
            }
        }
    }
}