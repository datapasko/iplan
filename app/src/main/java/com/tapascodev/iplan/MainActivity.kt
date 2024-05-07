package com.tapascodev.iplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.tapascodev.iplan.auth.ui.AuthActivity
import com.tapascodev.iplan.base.ui.startNewActivity
import com.tapascodev.iplan.home.ui.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        val condition = null // se debe validar existencia de user
        screenSplash.setKeepOnScreenCondition { false }

        val activity = if (condition == null) AuthActivity::class.java else HomeActivity::class.java
        startNewActivity(activity)
    }
}