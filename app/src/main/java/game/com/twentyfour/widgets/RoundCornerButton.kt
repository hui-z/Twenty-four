package game.com.twentyfour.widgets

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.Button
import game.com.twenty_four.R
import game.com.twentyfour.utils.UtilDrawable

class RoundCornerButton : Button {
    private var mCornerRadius = resources.getDimensionPixelSize(R.dimen.radius_card_view)
    private var mBgColorNormal = resources.getColor(R.color.btn_bg_normal)
    private var mBgColorPressed = resources.getColor(R.color.btn_bg_normal_pressed)
    private var mBgColorDisabled = resources.getColor(R.color.grey_ea)

    constructor(context: Context) : super(context) {
        initAttrs(context, null, 0)
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttrs(context, attrs, 0)
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttrs(context, attrs, defStyleAttr)
        init(context)
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.RoundCornerButton, defStyleAttr, 0)
        if (a != null) {
            mCornerRadius = a.getDimensionPixelSize(R.styleable.RoundCornerButton_corner_radius, mCornerRadius)
            mBgColorNormal = a.getColor(R.styleable.RoundCornerButton_background_color_normal, mBgColorNormal)
            mBgColorPressed = a.getColor(R.styleable.RoundCornerButton_background_color_pressed, mBgColorPressed)
            mBgColorDisabled = a.getColor(R.styleable.RoundCornerButton_background_color_disabled, mBgColorDisabled)
            a.recycle()
        }
    }

    private fun init(context: Context) {
        val normal = UtilDrawable.getRadiusRectDrawable(mBgColorNormal, mCornerRadius.toFloat(), 0, Color.TRANSPARENT)
        val pressed = UtilDrawable.getRadiusRectDrawable(mBgColorPressed, mCornerRadius.toFloat(), 0, Color.TRANSPARENT)
        val disabled = UtilDrawable.getRadiusRectDrawable(mBgColorDisabled, mCornerRadius.toFloat(), 0, Color.TRANSPARENT)
        setBackgroundDrawable(UtilDrawable.createStateDrawable(normal, pressed, null, disabled))
    }
}