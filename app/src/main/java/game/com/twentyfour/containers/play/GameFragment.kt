package game.com.twentyfour.containers.play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import game.com.twenty_four.R
import game.com.twentyfour.base.BaseFragment
import game.com.twentyfour.models.Poker
import kotlinx.android.synthetic.main.activity_game.*

/**
 * all views should be shown here
 * Created by yanyunhuang on 17/04/2018.
 */
class GameFragment : BaseFragment<GameContract.Presenter>(), GameContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : GameContract.View? {
        val mRoot = inflater.inflate(R.layout.activity_game, container, false)
        setUpListener()
        return mRoot
    }

    override fun onResume() {
        super.onResume()
        mPresenter.subscribe()
    }

    private fun setUpListener() {
        add.setOnClickListener { mPresenter.add() }
        minus.setOnClickListener { mPresenter.minus() }
        multi.setOnClickListener { mPresenter.multi() }
        divide.setOnClickListener { mPresenter.divide() }
    }

    override fun update(sheetValue: Int, scoreValue: Int, pointValue: Int, poker: Poker) {
        sheet.text = sheetValue.toString()
        score.text = scoreValue.toString()
        point.text = pointValue.toString()
        suit.text = poker.getSuit().name
        rangeTop.text = poker.getRange().name
        rangeBottom.text = poker.getRange().name
    }

    override fun setPresenter(presenter: GameContract.Presenter) {
        mPresenter = presenter
    }

    companion object {

        fun newInstance(): GameFragment {
            return GameFragment()
        }

    }
}