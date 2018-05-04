package game.com.twentyfour.widgets

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.RelativeLayout
import android.view.animation.TranslateAnimation



class DragView(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {
    private var lastX: Int = 0
    private var lastY: Int = 0

    private var originalX: Int = 0
    private var originalY: Int = 0

    private var addCallback: () -> Unit = {}
    private var minusCallback: () -> Unit = {}
    private var multipleCallback: () -> Unit = {}
    private var divideCallback: () -> Unit = {}

    override fun onTouchEvent(event: MotionEvent): Boolean {

        //获取到手指处的横坐标和纵坐标
        val x = event.x.toInt()
        val y = event.y.toInt()

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                originalX = getLeft()
                originalY = getTop()
                lastX = x
                lastY = y
                Log.d("ACTION_DOWN", "originalX = " + originalX + ", originalY = " + originalY)
                Log.d("ACTION_DOWN", "lastX = " + lastX + ", lastY = " + lastY)
                Log.d("ACTION_DOWN", "x = " + x + ", y = " + y)
            }
            MotionEvent.ACTION_MOVE -> {
                //计算移动的距离
                val offX = x - lastX
                val offY = y - lastY
                //调用layout方法来重新放置它的位置
                layout(getLeft() + offX, getTop() + offY, getRight() + offX, getBottom() + offY)
                Log.d("ACTION_MOVE", "lastX = " + lastX + ", lastY = " + lastY)
                Log.d("ACTION_MOVE", "x = " + x + ", y = " + y + ", offX = " + offX + ", offY = " + offY)
            }
            MotionEvent.ACTION_UP -> {
                val offsetX = x - originalX
                val offsetY = y - originalY
                Log.d("ACTION_UP", "offsetX = " + offsetX + ", offsetY = " + offsetY)
                if (Math.abs(offsetX) < 40 && Math.abs(offsetY) < 40) {
//                    moveBack(x, originalX, y, originalY)
                } else if (Math.abs(offsetX) > Math.abs(offsetY)) {
                    if (offsetX > 0) divideCallback
                    else multipleCallback
                } else {
                    if (offsetY > 0) minusCallback
                    else addCallback
                }
                Log.d("ACTION_UP", "x = " + x + ", y = " + y)
            }
        }
        return true
    }

    fun setCallbacks(add: () -> Unit, minus: () -> Unit, multiple: () -> Unit, divide: () -> Unit) {
        addCallback = add
        minusCallback = minus
        multipleCallback = multiple
        divideCallback = divide
    }

    fun moveBack(fromX: Int, targetX: Int, fromY: Int, targetY: Int) {
        Log.d("moveBack", "fromX = " + fromX + "targetX = " + targetX + ", fromY = " + fromY + ", targetY = " + targetY)
        val translateAnimation = TranslateAnimation(fromX.toFloat(), targetX.toFloat(), fromY.toFloat(), targetY.toFloat())
        translateAnimation.duration = 300
        setAnimation(translateAnimation)
        startAnimation(translateAnimation)
    }
}