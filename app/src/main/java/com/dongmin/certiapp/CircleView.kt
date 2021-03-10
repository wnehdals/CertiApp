package com.dongmin.certiapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.RED
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.internal.ViewUtils.dpToPx
import java.lang.Integer.getInteger
import java.util.jar.Attributes

class CircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : View(context, attrs, defStyle){
    private val mainPaint: Paint = Paint()
    private val backgroundPaint: Paint = Paint()
    private var rectangle: RectF? = null
    private var margin: Float = 0f
    private var arcProportion: Float = 0f
    private var mainColorVal: Int = R.color.teal_200
    private var backgroundColorVal: Int = R.color.black
    private var strokeSize = 5
    private var marginSize = 3f
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (rectangle == null) {
            rectangle = RectF(0f + margin, 0f + margin, width.toFloat() - margin, height.toFloat() - margin)
        }
        canvas?.drawArc(rectangle!!, -90f, arcProportion * 360, false, mainPaint)
        // This 2nd arc completes the circle. Remove it if you don't want it
        canvas?.drawArc(rectangle!!, -90f + arcProportion * 360, (1 - arcProportion) * 360, false, backgroundPaint)
    }
    fun init(attrs: AttributeSet?){
        attrs?.run {
            context.obtainStyledAttributes(this, R.styleable.CircleView)
        }?.run {
            mainColorVal = getColor(R.styleable.CircleView_mainColorVal, mainColorVal)
            backgroundColorVal = getColor(R.styleable.CircleView_backgroundColorVal, backgroundColorVal)
            arcProportion = getFloat(R.styleable.CircleView_arcProportion, arcProportion)
            strokeSize = getInt(R.styleable.CircleView_strokeSize, strokeSize)
            margin = getFloat(R.styleable.CircleView_marginSize, marginSize)
            recycle()
            invalidate()
        }
    }
    init {
        init(attrs)
        mainPaint.run{
            isAntiAlias = true
            color = mainColorVal
            style = Paint.Style.STROKE
            strokeWidth = dpToPx(context,strokeSize)
        }
        backgroundPaint.run{
            isAntiAlias = true
            color = backgroundColorVal
            style = Paint.Style.STROKE
            strokeWidth = dpToPx(context,strokeSize)
        }
        margin = dpToPx(context,marginSize.toInt()) // margin should be >= strokeWidth / 2 (otherwise the arc is cut)
    }
    fun setArcProportion(arcProportion: Float) {
        this.arcProportion = arcProportion
        invalidate()
    }
}