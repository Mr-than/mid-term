package com.example.redrockmterm.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.redrockmterm.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin
import kotlin.properties.Delegates

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

        paint= Paint()
        paint.strokeWidth = 25f;
        paint.color = Color.RED;
        paint.isDither = true;
        paint.style = Paint.Style.STROKE;
        paint.strokeJoin = Paint.Join.ROUND;
        paint.strokeCap = Paint.Cap.ROUND;
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
        canvas.save()
        canvas.clipPath(path)
        canvas.drawBitmap(bitmap,centerX.toFloat()-r,centerY.toFloat()-r,paint)
        canvas.restore()
    }
    fun setPhoto(re:Int){
        bitmap=BitmapFactory.decodeResource(resources, re)
        paint.reset()

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