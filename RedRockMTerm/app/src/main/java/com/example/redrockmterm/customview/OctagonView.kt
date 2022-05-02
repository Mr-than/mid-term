package com.example.redrockmterm.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.redrockmterm.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin


class OctagonView : View {

    private var centerX: Int = 0
    private var centerY: Int = 0
    private var r: Float = 0F
    private lateinit var paint: Paint
    private lateinit var path: Path
    private var a: Float = 0F
    private lateinit var region: Region
    private val job= Job()
    private val scope= CoroutineScope(job)
    private var isDraw=false

    private lateinit var bitmap:Bitmap


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


    private fun init(context: Context) {
        setLayerType(LAYER_TYPE_SOFTWARE,null)
        path = Path()

       // bitmap=BitmapFactory.decodeResource(resources, R.id.cardView)

        paint= Paint()
        paint.strokeWidth = 25f
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.isFilterBitmap = true; //对Bitmap进行滤波处理
        paint.isAntiAlias = true;//设置抗锯齿

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        centerX = w / 2
        centerY = h / 2
        r = min(w, h) / 2 * 0.9.toFloat()
        postInvalidate()
        super.onSizeChanged(w, h, oldw, oldh)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        setE()
        path.close()

        if(isDraw) {

            canvas.save()
            canvas.clipPath(path)
            val rect = Rect(
                (centerX - r).toInt(), (centerY - r).toInt(), (centerX + r).toInt(),
                (centerY + r).toInt()
            )

            val pfd = PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
            canvas.drawFilter = pfd
            canvas.drawBitmap(bitmap, null, rect, paint)

            canvas.restore()
        }
      }
    fun setPhoto(re:Bitmap){
        bitmap=re
        paint.reset()
        isDraw=true
        invalidate()
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
       val height = 200;
        val width = 200;
        val widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        val widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        val heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        val heightSpecSize = MeasureSpec.getMode(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width,height);
        }else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width,heightSpecSize);
        }else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize,height);
        }
    }
    private fun setE(){
        for (i in 0 until 8) {
            if (i == 0) {
                path.moveTo(
                    (centerX + r * cos(2 * Math.PI * i / 8)).toFloat(),
                    (centerY + r * sin(2 * Math.PI * i / 8)).toFloat()
                )
            } else {
                path.lineTo(
                    (centerX + r * cos(2 * Math.PI * i / 8)).toFloat(),
                    (centerY + r * sin(2 * Math.PI * i / 8)).toFloat()
                )
            }
        }
        path.close()
    }


}