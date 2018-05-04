package game.com.twentyfour.utils

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.util.StateSet

object UtilDrawable {

    @JvmStatic
    @JvmOverloads fun createStateDrawable(normal: Drawable, pressed: Drawable, focused: Drawable? = null, disabled: Drawable? = null): StateListDrawable {
        val sd = StateListDrawable()
        sd.addState(intArrayOf(android.R.attr.state_pressed), pressed)
        sd.addState(intArrayOf(android.R.attr.state_focused), focused)
        sd.addState(intArrayOf(-android.R.attr.state_enabled), disabled)
        sd.addState(StateSet.WILD_CARD, normal)
        return sd
    }

    /**
     * 创建圆角矩形Drawable
     * @param solidColor 填充色
     *
     * @param radius 圆角半径
     *
     * @param strokeWidth 描边宽度，没有描边可设置为0
     *
     * @param strokeColor 描边颜色，没有描边可设置为[android.graphics.Color.TRANSPARENT]
     */
    fun getRadiusRectDrawable(solidColor: Int, radius: Float, strokeWidth: Int = 0, strokeColor: Int = android.graphics.Color.TRANSPARENT): GradientDrawable {
        val drawable = getRectDrawable(solidColor, strokeWidth, strokeColor)
        drawable.cornerRadius = radius
        return drawable
    }

    fun getRectDrawable(solidColor: Int, strokeWidth: Int = 0, strokeColor: Int = android.graphics.Color.TRANSPARENT): GradientDrawable {
        val drawable = GradientDrawable()
        drawable.shape = GradientDrawable.RECTANGLE
        drawable.setColor(solidColor)
        drawable.setStroke(strokeWidth, strokeColor)
        return drawable
    }
}