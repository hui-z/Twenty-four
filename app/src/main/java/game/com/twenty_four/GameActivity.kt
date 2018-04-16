package game.com.twenty_four

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_game.*

/**
 * Created by yanyunhuang on 23/03/2018.
 */
class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)

//        go.setOnClickListener {
//            GameActivity.explicitStart(baseContext)
//            this.finish()
//        }

    }



    companion object {

        fun explicitStart(context: Context) {
            context?.startActivity(Intent(context, GameActivity::class.java))
        }
    }
}