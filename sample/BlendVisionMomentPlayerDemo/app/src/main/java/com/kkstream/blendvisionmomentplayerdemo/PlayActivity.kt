package com.kkstream.blendvisionmomentplayerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import com.kkstream.android.blendvisionmoment.BlendVisionMomentPlayer
import com.kkstream.android.blendvisionmoment.data.BarItem
import com.kkstream.android.blendvisionmoment.data.Configuration
import com.kkstream.android.blendvisionmoment.data.PlayerContext

class PlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        // define a container in your layout to embed the player in
        val container: ViewGroup = findViewById<FrameLayout>(R.id.container)

        // Fetch a access token from your moment service CMS
        val token: String = fetchToken()
        
        // Select a default resolution to start the LIVE Streaming
        val defaultResolution = 720

        BlendVisionMomentPlayer.presentPlayer(
            playerContext = PlayerContext(
                activity = this,
                container = container,
                configuration = Configuration(defaultResolution = defaultResolution),
                barItems = listOf(BarItem.Settings)
            ),
            token = token
        )
    }

    private fun fetchToken(): String {
        return "ACCESS_TOKEN"
    }
}