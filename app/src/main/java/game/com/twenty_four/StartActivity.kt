package game.com.twenty_four

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_start)

        go.setOnClickListener {
            GameActivity.explicitStart(baseContext)
            this.finish()
//            localNotification()
        }

    }

//    private fun localNotification() {
//
//        Log.d("", "localNotification");
//        val mNotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        val notifyBuilder = NotificationCompat.Builder(this)
//                .setContentTitle("title")
//                .setContentText("xxxxxxxx")
//                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC) // 锁屏上展示通知
//                .setPriority(Notification.PRIORITY_MAX) // 设置该通知优先级
//                .setAutoCancel(true)
//                .setTicker("再惠合伙人")
//                .setSmallIcon(R.drawable.notification_icon_background)
//        val notification = notifyBuilder.build()
//        mNotificationManager.notify(1, notification);
//    }

}
