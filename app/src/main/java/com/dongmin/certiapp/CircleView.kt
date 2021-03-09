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

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (rectangle == null) {
            rectangle = RectF(0f + margin, 0f + margin, width.toFloat() - margin, height.toFloat() - margin)
        }
        canvas?.drawArc(rectangle!!, -90f, arcProportion * 360, false, mainPaint)
        // This 2nd arc completes the circle. Remove it if you don't want it
        canvas?.drawArc(rectangle!!, -90f + arcProportion * 360, (1 - arcProportion) * 360, false, backgroundPaint)
    }

    init {

        mainPaint.isAntiAlias = true
        mainPaint.color = ContextCompat.getColor(context, mainColorVal)
        mainPaint.style = Paint.Style.STROKE
        //mainPaint.strokeWidth = dpToPx(context,5)
        backgroundPaint.isAntiAlias = true
        backgroundPaint.color = ContextCompat.getColor(context, backgroundColorVal)
        backgroundPaint.style = Paint.Style.STROKE
        //backgroundPaint.strokeWidth = dpToPx(context,5)
        //margin = dpToPx(context,3) // margin should be >= strokeWidth / 2 (otherwise the arc is cut)
    }
    fun setArcProportion(arcProportion: Float) {
        this.arcProportion = arcProportion
        invalidate()
    }
}