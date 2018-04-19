package game.com.twentyfour.base

import android.app.Fragment

/**
 * all fragments should extend this class
 * Created by yanyunhuang on 17/04/2018.
 */
abstract class BaseFragment<T : BasePresenter> : Fragment(), BaseView<T> {

    protected lateinit var mPresenter: T

    override fun setPresenter(presenter: T) {
        mPresenter = presenter
    }

}