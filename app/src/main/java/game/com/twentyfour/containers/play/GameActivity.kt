package game.com.twentyfour.containers.play

import android.content.Context
import android.content.Intent
import android.os.Bundle
import game.com.twenty_four.R
import game.com.twentyfour.base.BaseActivity

/**
 * Created by yanyunhuang on 23/03/2018.
 */
class GameActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        initContent()
    }

    private fun initContent() {
        val fragment = supportFragmentManager.findFragmentById(R.id.contentFrame)
        val gameFragment =
                if (fragment != null) fragment as GameFragment
                else GameFragment.newInstance()

        GamePrsenter(gameFragment)

        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.contentFrame, gameFragment, gameFragment.javaClass.simpleName)
        transaction.addToBackStack(gameFragment.javaClass.simpleName)
        transaction.commit()
    }
    

    companion object {
        fun explicitStart(context: Context) {
            context.startActivity(Intent(context, GameActivity::class.java))
        }
    }
}