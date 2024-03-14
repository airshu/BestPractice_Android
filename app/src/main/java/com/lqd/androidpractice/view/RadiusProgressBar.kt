package com.lqd.androidpractice.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class RadiusProgressBar : View {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        setLayerType(LAYER_TYPE_HARDWARE, null)
    }

    private var radius: Float = 4f
    private var progress: Int = 0
    private var progressBitmap: Bitmap? = null
    private val paint = Paint().apply { isAntiAlias = true }

    fun setProgress(progress: Int) {
        when {
            progress < 0 -> this.progress = 0
            progress > 100 -> this.progress = 100
            else -> this.progress = progress
        }
        invalidate()
    }

    fun setProgressBitmap(bitmap: Bitmap) {
        progressBitmap = bitmap
    }

    fun setRadius(radius: Float){
        this.radius = radius
    }
    override fun onDraw(canvas: Canvas) {
        paint.xfermode = null
        progressBitmap?.let { bitmap ->
            val progressWidth = progress / 100f * width
            if (bitmap.width >= progressWidth) {
                //画圆角边框
                val rect = RectF(0f, 0f, progressWidth, height.toFloat())
                canvas?.drawRoundRect(rect, radius, radius, paint)

                //画图片
                paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
                val srcRect = Rect(0, 0, progressWidth.toInt(), bitmap.height)
                val destRect = RectF(0f, 0f, progressWidth, height.toFloat())
                canvas?.drawBitmap(bitmap, srcRect, destRect, paint)
            } else {
                val srcRect = Rect(0, 0, bitmap.width, bitmap.height)
                val destRect = RectF(0f, 0f, progressWidth, height.toFloat())
                canvas?.drawBitmap(bitmap, srcRect, destRect, paint)
            }
        }
    }
}