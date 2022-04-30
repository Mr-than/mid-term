package com.example.redrockmterm.customview
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Scroller
import androidx.core.view.ViewConfigurationCompat
import com.example.redrockmterm.databinding.CenterActivityMainBinding
import kotlin.math.abs

class ScrollerDownView : ViewGroup {

    private lateinit var mScroller: Scroller
    private lateinit var centerBinding:CenterActivityMainBinding
    private var maxMove: Int = 0
    private var downY: Float = 0F
    private var lastY: Float = 0F
    private var moveY: Float = 0F
    private var bottomBolder: Int = 0
    private var topBolder: Int = 0
    private var refreshY: Int = 0
    private var fromDegrees=0F
    private var firstTop:Int=0
    private var isDo:Boolean=true
    private lateinit var rotateAnimation:RotateAnimation
    private lateinit var backAnimation: RotateAnimation


    constructor(context: Context) : super(context) {
        init(context)

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(context)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val thisMeasureWith = MeasureSpec.getSize(widthMeasureSpec)
        val thisMeasureHeight = MeasureSpec.getSize(heightMeasureSpec)
        val measureWithMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)

        var height = 0
        var width = 0
        val count = childCount

        for (i in 0 until count) {
            val child = getChildAt(i)

            measureChild(child, widthMeasureSpec, heightMeasureSpec)

            width = child.measuredWidth
            height += child.measuredHeight
        }

        setMeasuredDimension(
            if (measureWithMode == MeasureSpec.EXACTLY) {
                thisMeasureWith
            } else {
                width
            },
            if (measureHeightMode == MeasureSpec.EXACTLY) {
                thisMeasureHeight
            } else {
                height
            }
        )

    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {

        var height = 0
        val count = childCount

        for (i in 0 until count) {
            val child = getChildAt(i)
            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight

            child.layout(0, height, childWidth, height + childHeight)
            if(i+1<count){
                height -= getChildAt(i+1).measuredHeight
            }
        }

        bottomBolder = getChildAt(0).bottom
        topBolder = getChildAt(count - 1).top
        firstTop=getChildAt(0).top
        refreshY = getChildAt(count - 1).bottom
        centerBinding= CenterActivityMainBinding.bind(getChildAt(1))

    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                downY = ev.rawY
                lastY = downY
            }

            MotionEvent.ACTION_MOVE -> {
                moveY = ev.rawY
                val diff = abs(moveY - downY)
                lastY = moveY
                if (diff > maxMove) {
                    return true
                }
            }
        }
        return super.onInterceptTouchEvent(ev)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {

                moveY = event.rawY


                var scrollerY:Float= lastY - moveY


                if(scrollY<refreshY-100){
                    scrollerY=0F
                }

                if (scrollY + scrollerY + height > bottomBolder) {
                    scrollTo(0, 0)
                    return true
                } else if (scrollY + scrollerY < topBolder) {
                    scrollTo(0, topBolder)

                    return true
                }

                scrollBy(0, scrollerY.toInt())

                if (scrollY > refreshY) {
                    centerBinding.centerText.text="继续下拉"
                }else{
                    centerBinding.centerText.text="释放进入菜单"
                }

                if(-scrollY>180&&isDo) {

                    centerBinding.centerArrow.startAnimation(rotateAnimation)
                    isDo=false
                }
                lastY = moveY

            }

            MotionEvent.ACTION_UP -> {
                if (scrollY > refreshY) {
                    isDo=true
                    centerBinding.centerArrow.startAnimation(backAnimation)
                    mScroller.startScroll(0, scrollY, 0, -scrollY)
                } else if (scrollY < refreshY) {
                    isDo=true
                    centerBinding.centerArrow.startAnimation(backAnimation)
                    mScroller.startScroll(0, scrollY, 0, topBolder - scrollY)
                }
                invalidate()
            }
        }

        return super.onTouchEvent(event)
    }

    override fun computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.currX, mScroller.currY)
            invalidate()
        }


    }

    private fun init(context: Context) {
        mScroller = Scroller(context)
        maxMove = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context))

        rotateAnimation = RotateAnimation(0F, 180F,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F)
        rotateAnimation.fillAfter=true
        rotateAnimation.duration=400

        backAnimation =RotateAnimation(180F, 0F,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F)
        backAnimation.fillAfter=true
        backAnimation.duration=1

    }

    fun backScroll(){
        mScroller.startScroll(0,scrollY,0,-scrollY)
        invalidate()
    }

}