package game.com.twentyfour.containers.play

import game.com.twentyfour.base.BasePresenter
import game.com.twentyfour.base.BaseView

/**
 * Created by yanyunhuang on 17/04/2018.
 */
interface GameContract {

    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {

    }
}