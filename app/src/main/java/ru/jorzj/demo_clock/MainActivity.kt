package ru.jorzj.demo_clock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.jorzj.clock_ui.api.starter.DrawContent
import ru.jorzj.clock_ui.api.starter.buildComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = buildComponent()
        setContent { DrawContent(component) }
    }
}