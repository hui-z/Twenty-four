package game.com.twentyfour.containers.play

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import game.com.twenty_four.R

/**
 * Created by yanyunhuang on 23/03/2018.
 */
class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

    }



    companion object {
        fun explicitStart(context: Context) {
            context?.startActivity(Intent(context, GameActivity::class.java))
        }
    }
}