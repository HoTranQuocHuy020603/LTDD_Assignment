package com.example.bt8

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.widget.Toast

class MusicService : Service() {

    var player = MediaPlayer()

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this@MusicService,R.raw.cat2)
        player.isLooping
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if(player.isPlaying) {
            player.pause()
        }
        else{
            player.start()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
            player.stop()
    }

}
