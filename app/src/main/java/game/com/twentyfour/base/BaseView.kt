package game.com.twentyfour.base

/**
 * Created by yanyunhuang on 17/04/2018.
 */
interface BaseView<in T> {

    fun setPresenter(presenter: T)

}