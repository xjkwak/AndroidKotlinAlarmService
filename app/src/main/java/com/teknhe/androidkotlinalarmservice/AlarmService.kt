package com.teknhe.androidkotlinalarmservice

import android.app.Service
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.IBinder

class AlarmService : Service() {
   override fun onBind(intent: Intent?): IBinder? {
        return null
   }

   private lateinit var ringtone: Ringtone

   override fun onCreate() {
       val notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
       ringtone = RingtoneManager.getRingtone(this, notification)
       super.onCreate()
   }

   override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
       playAlarm()
       return super.onStartCommand(intent, flags, startId)
   }

   private fun playAlarm() {
       println("playAlarm()")

       if(!ringtone.isPlaying()) {
           ringtone.play()
       }
   }

   override fun onDestroy() {
       println("onDestroy()")
       ringtone.stop()
       super.onDestroy()
   }
}
