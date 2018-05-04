package game.com.twentyfour.containers.play

import game.com.twentyfour.models.Poker
import game.com.twentyfour.models.Ranges
import game.com.twentyfour.models.Suits
import java.util.*

/**
 * used to privode data source shown in fragment
 * Created by yanyunhuang on 17/04/2018.
 */
class GamePrsenter(private val mView: GameContract.View) : GameContract.Presenter{

    private val mPokerPool: MutableList<Poker> = mutableListOf()
    private lateinit var mCurrentPoker: Poker
    private var mScore: Int = 0 // 当前计算值
    private var mSheet: Int = 0 // 已使用牌张数
    private var mPoint: Int = 0 // TODO bonus

    init {
        mView.setPresenter(this)

    }

    override fun subscribe() {
        resetPokerPool()
    }

    private fun randomCreatePoker(): Poker? {
        if (mPokerPool.size > 0) {
            val poker = mPokerPool[(Random().nextInt(mPokerPool.size))]
            mCurrentPoker = poker
            return poker
        }
        else return null
    }

    override fun compute(cal: Calculation){
        when (cal) {
            Calculation.ADD -> mScore += getRangeValue(mCurrentPoker)
            Calculation.MINUS -> mScore -=  getRangeValue(mCurrentPoker)
            Calculation.MULTIPLE -> mScore *=  getRangeValue(mCurrentPoker)
            Calculation.DIVIDE -> mScore /=  getRangeValue(mCurrentPoker)

        }
        mSheet += 1
        mPokerPool.remove(mCurrentPoker)
        mView.update(mSheet, mScore, mPoint, randomCreatePoker())
    }

    private fun getRangeValue(poker: Poker): Int {
        val value = poker.getRange().ordinal + 1
        if (value > 10) return 10
        else return value
    }

    override fun unSubscribe() {
    }

    override fun resetPokerPool() {
        mPokerPool.clear()
        val suitsList = listOf(Suits.Spade, Suits.Heart, Suits.Diamond, Suits.Club)

        val rangeList = listOf(Ranges.Ace, Ranges.two, Ranges.three, Ranges.four, Ranges.five,
                Ranges.six, Ranges.seven, Ranges.eight, Ranges.nine, Ranges.ten, Ranges.Jack,
                Ranges.Queen, Ranges.King)

        suitsList.forEach { suit ->
            rangeList.forEach { range ->
                mPokerPool.add(Poker(suit, range))
            }
        }
        mScore = 0
        mSheet = 0
        mPoint = 0
        mView.update(mSheet, mScore, mPoint, randomCreatePoker())
    }

    override fun skip() {
        mView.update(mSheet, mScore, mPoint, randomCreatePoker())
    }

    companion object {
        enum class Calculation {
            ADD,
            MINUS,
            MULTIPLE,
            DIVIDE,
        }
    }
}