package game.com.twentyfour.containers.play

import game.com.twentyfour.base.BasePresenter
import game.com.twentyfour.base.BaseView
import game.com.twentyfour.models.Poker

/**
 * Created by yanyunhuang on 17/04/2018.
 */
interface GameContract {

    interface View : BaseView<Presenter> {

        fun update(sheet: Int, score: Int, point: Int, poker: Poker?)
    }

    interface Presenter : BasePresenter {

        fun compute(cal: GamePrsenter.Companion.Calculation)

        fun resetPokerPool()
    }
}