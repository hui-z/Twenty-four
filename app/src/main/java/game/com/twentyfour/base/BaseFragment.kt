package game.com.twentyfour.base

import android.support.v4.app.Fragment

/**
 * all fragments should extend this class
 * Created by yanyunhuang on 17/04/2018.
 */
abstract class BaseFragment<T : BasePresenter> : Fragment() {

    protected lateinit var mPresenter: T

}