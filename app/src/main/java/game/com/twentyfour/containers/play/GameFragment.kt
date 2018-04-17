package game.com.twentyfour.containers.play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import game.com.twenty_four.R
import game.com.twentyfour.base.BaseFragment

/**
 * all views should be shown here
 * Created by yanyunhuang on 17/04/2018.
 */
class GameFragment : BaseFragment<GameContract.Presenter>(), GameContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mRoot = inflater.inflate(R.layout.activity_game, container, false)
        return mRoot
    }

    companion object {

        fun newInstance(): GameFragment {
            return GameFragment()
        }

    }
}