package game.com.twentyfour.containers.play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import game.com.twenty_four.R
import game.com.twentyfour.base.BaseFragment
import game.com.twentyfour.models.Poker
import kotlinx.android.synthetic.main.fragment_game.view.*
import android.content.DialogInterface
import android.app.AlertDialog
import kotlinx.android.synthetic.main.fragment_game.*

/**
 * all views should be shown here
 * Created by yanyunhuang on 17/04/2018.
 */
class GameFragment : BaseFragment<GameContract.Presenter>(), GameContract.View {

    private lateinit var mRoot: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        mRoot = inflater.inflate(R.layout.fragment_game, container, false)
        setUpListener()
        return mRoot
    }

    override fun onResume() {
        super.onResume()
        mPresenter.subscribe()
    }

    private fun setUpListener() {
        mRoot.add.setOnClickListener { mPresenter.compute(GamePrsenter.Companion.Calculation.ADD) }
        mRoot.minus.setOnClickListener { mPresenter.compute(GamePrsenter.Companion.Calculation.MINUS) }
        mRoot.multi.setOnClickListener { mPresenter.compute(GamePrsenter.Companion.Calculation.MULTIPLE) }
        mRoot.divide.setOnClickListener { mPresenter.compute(GamePrsenter.Companion.Calculation.DIVIDE) }
        mRoot.skip.setOnClickListener {mPresenter.skip()}
        mRoot.poker.setCallbacks(
                {mPresenter.compute(GamePrsenter.Companion.Calculation.ADD)},
                {mPresenter.compute(GamePrsenter.Companion.Calculation.MINUS)},
                {mPresenter.compute(GamePrsenter.Companion.Calculation.MULTIPLE)},
                {mPresenter.compute(GamePrsenter.Companion.Calculation.DIVIDE)})
    }

    override fun update(sheetValue: Int, scoreValue: Int, pointValue: Int, poker: Poker?) {
        mRoot.sheet.text = sheetValue.toString()
        mRoot.score.text = scoreValue.toString()
        mRoot.point.text = pointValue.toString()

        if (scoreValue == 24) popupWin()
        else if (sheetValue == 52) popupFailed()

        if (poker != null) {
            mRoot.suit.text = poker.getSuit().name
            mRoot.rangeTop.text = poker.getRange().name
            mRoot.rangeBottom.text = poker.getRange().name
        }
    }

    private fun popupWin() {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Congratulations, you win")
                .setPositiveButton("Play again!", DialogInterface.OnClickListener { dialog, id ->
                    mPresenter.resetPokerPool()
                })
                .setNegativeButton("No, thanks.", DialogInterface.OnClickListener { dialog, id ->
                })
        builder.create()
        builder.show()
    }

    private fun popupFailed() {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Oooh, you lose")
                .setPositiveButton("Play again!", DialogInterface.OnClickListener { _, _ ->
                    mPresenter.resetPokerPool()
                })
                .setNegativeButton("No, thanks.", DialogInterface.OnClickListener { _, _ ->
                })
        builder.create()
        builder.show()
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