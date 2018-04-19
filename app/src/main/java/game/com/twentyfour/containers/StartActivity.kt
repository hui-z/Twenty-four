package game.com.twentyfour.containers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import game.com.twenty_four.R
import game.com.twentyfour.containers.play.GameActivity
import kotlinx.android.synthetic.main.activity_start.*

/**
 * the entrance of app
 */
class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_start)

        go.setOnClickListener {
            GameActivity.explicitStart(this)
            this.finish()
        }
    }

}
