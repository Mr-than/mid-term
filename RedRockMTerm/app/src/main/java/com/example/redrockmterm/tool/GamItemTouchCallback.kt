package com.example.redrockmterm.tool

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


class GamItemTouchCallback(private val mDefaultScrollX: Int, private val move: Move,recyclerView: RecyclerView) :
    ItemTouchHelper.Callback() {
    private var mCurrentScrollX = 0
    private var mCurrentScrollXWhenInactive = 0
    private var mInitXWhenInactive = 0f
    private var mFirstInactive = false
    private lateinit var view:View

    private var isBack=false

    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        // 上下拖动
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        // 向左滑动
        val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return Int.MAX_VALUE.toFloat()
    }

    override fun getSwipeEscapeVelocity(defaultValue: Float): Float {
        return Int.MAX_VALUE.toFloat()
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        move.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            if (dX == 0f) {
                mCurrentScrollX = viewHolder.itemView.scrollX
                mFirstInactive = true
            }
            if (isCurrentlyActive) {
                viewHolder.itemView.scrollTo(mCurrentScrollX - dX.toInt(), 0)
            } else {
                if (mFirstInactive) {
                    mFirstInactive = false
                    mCurrentScrollXWhenInactive = viewHolder.itemView.scrollX
                    mInitXWhenInactive = dX
                }
                if (viewHolder.itemView.scrollX >= mDefaultScrollX) {
                    viewHolder.itemView.scrollTo(mDefaultScrollX, 0)
                    isBack=false

                    recyclerView.setOnTouchListener { _, _ ->
                        view=viewHolder.itemView

                        if(!isBack) {
                            isBack=true
                            view.scrollTo(
                                (mCurrentScrollXWhenInactive * dX / mInitXWhenInactive).toInt(),
                                0
                            )
                        }
                        false
                    }

                } else {

                    viewHolder.itemView.scrollTo((mCurrentScrollXWhenInactive * dX / mInitXWhenInactive).toInt(), 0)
                }
            }
        } else {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        if (viewHolder.itemView.scrollX >= mDefaultScrollX) {
            viewHolder.itemView.scrollTo(mDefaultScrollX, 0)
        } else if (viewHolder.itemView.scrollX < 0) {
            viewHolder.itemView.scrollTo(0, 0)
        }
    }

    interface Move {
        fun onItemMove(from: Int, to: Int)
    }
}
