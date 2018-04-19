package game.com.twentyfour.models

/**
 * Created by yanyunhuang on 17/04/2018.
 */
class Poker( final val mSuit: Suits, final val mRange: Ranges) {

    fun getRange(): Ranges = mRange

    fun getSuit(): Suits = mSuit
}