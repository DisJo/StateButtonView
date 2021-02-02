package jo.dis.button

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class StateButtonView : AppCompatTextView {

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, style: Int = 0) : super(context, attrs, style) {

        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.StateButtonView, 0, 0)

        val drawableBuilder = DrawableBuilder()
        val ripple = typedArray.getBoolean(R.styleable.StateButtonView_ripple, false)
        val rippleColor = typedArray.getColor(R.styleable.StateButtonView_ripple_color, Constants.COLOR_DEFAULT)
        val useGradient = typedArray.getBoolean(R.styleable.StateButtonView_use_gradient, false)
        val angle = typedArray.getInteger(R.styleable.StateButtonView_angle, 90)
        val normalStartColor = typedArray.getColor(R.styleable.StateButtonView_normal_start_color, Constants.COLOR_DEFAULT)
        val normalEndColor = typedArray.getColor(R.styleable.StateButtonView_normal_end_color, Constants.COLOR_DEFAULT_DARK)
        val pressedStartColor = typedArray.getColor(R.styleable.StateButtonView_pressed_start_color, Constants.COLOR_PRESSED)
        val pressedEndColor = typedArray.getColor(R.styleable.StateButtonView_pressed_end_color, Constants.COLOR_PRESSED_DARK)
        val selectedStartColor = typedArray.getColor(R.styleable.StateButtonView_selected_start_color, Constants.COLOR_PRESSED)
        val selectedEndColor = typedArray.getColor(R.styleable.StateButtonView_selected_end_color, Constants.COLOR_PRESSED_DARK)
        val disabledStartColor = typedArray.getColor(R.styleable.StateButtonView_disabled_start_color, Constants.COLOR_DISABLED)
        val disabledEndColor = typedArray.getColor(R.styleable.StateButtonView_disabled_end_color, Constants.COLOR_DISABLED_DARK)
        val rounded = typedArray.getBoolean(R.styleable.StateButtonView_rounded, false)
        val cornerRadius = typedArray.getDimensionPixelSize(R.styleable.StateButtonView_corner_radius, 0)
        val topLeftRadius = typedArray.getDimensionPixelSize(R.styleable.StateButtonView_top_left_radius, 0)
        val topRightRadius = typedArray.getDimensionPixelSize(R.styleable.StateButtonView_top_right_radius, 0)
        val bottomLeftRadius = typedArray.getDimensionPixelSize(R.styleable.StateButtonView_bottom_left_radius, 0)
        val bottomRightRadius = typedArray.getDimensionPixelSize(R.styleable.StateButtonView_bottom_right_radius, 0)
        val solidColor = typedArray.getColor(R.styleable.StateButtonView_solid_color, Constants.COLOR_DEFAULT)
        val solidColorPressed = typedArray.getColor(R.styleable.StateButtonView_solid_color_pressed, Constants.COLOR_PRESSED)
        val solidColorSelected = typedArray.getColor(R.styleable.StateButtonView_solid_color_selected, Constants.COLOR_PRESSED)
        val solidColorDisabled = typedArray.getColor(R.styleable.StateButtonView_solid_color_disabled, Constants.COLOR_DISABLED)
        val strokeWidth = typedArray.getDimensionPixelSize(R.styleable.StateButtonView_stroke_width, 0)
        val strokeColor = typedArray.getColor(R.styleable.StateButtonView_stroke_color, 0)
        val strokeColorPressed = typedArray.getColor(R.styleable.StateButtonView_stroke_color_pressed, 0)
        val strokeColorSelected = typedArray.getColor(R.styleable.StateButtonView_stroke_color_selected, 0)
        val strokeColorDisabled = typedArray.getColor(R.styleable.StateButtonView_stroke_color_disabled, 0)

        when {
            rounded -> {
                drawableBuilder.cornerRadius(Int.MAX_VALUE)
            }
            cornerRadius > 0 -> {
                drawableBuilder.cornerRadius(cornerRadius)
            }
            else -> {
                drawableBuilder.topLeftRadius(topLeftRadius)
                drawableBuilder.topRightRadius(topRightRadius)
                drawableBuilder.bottomLeftRadius(bottomLeftRadius)
                drawableBuilder.bottomRightRadius(bottomRightRadius)
            }
        }

        drawableBuilder.ripple(ripple)
        drawableBuilder.rippleColor(rippleColor)

        drawableBuilder.strokeWidth(strokeWidth)
        drawableBuilder.strokeColor(strokeColor)
        if (!ripple) {
            drawableBuilder.strokeColorPressed(strokeColorPressed)
            drawableBuilder.strokeColorSelected(strokeColorSelected)
        }
        drawableBuilder.strokeColorDisabled(strokeColorDisabled)

        if (useGradient) {
            drawableBuilder.gradient()
            drawableBuilder.linearGradient()
            drawableBuilder.angle(angle)

            val normalState = drawableBuilder
                    .startColor(normalStartColor)
                    .endColor(normalEndColor)
                    .build()
            val pressedState = drawableBuilder
                    .startColor(pressedStartColor)
                    .endColor(pressedEndColor)
                    .build()
            val selectedState = drawableBuilder
                    .startColor(selectedStartColor)
                    .endColor(selectedEndColor)
                    .build()
            val disabledState = drawableBuilder
                    .startColor(disabledStartColor)
                    .endColor(disabledEndColor)
                    .build()

            val stateListDrawableBuilder = StateListDrawableBuilder()
            stateListDrawableBuilder.normal(normalState)
            if (!ripple) {
                stateListDrawableBuilder.pressed(pressedState)
                stateListDrawableBuilder.selected(selectedState)
            }
            stateListDrawableBuilder.disabled(disabledState)

            val drawable = stateListDrawableBuilder.build()
            setBackgroundDrawable(drawable)
        } else {
            drawableBuilder.solidColor(solidColor)
            if (!ripple) {
                drawableBuilder.solidColorPressed(solidColorPressed)
                drawableBuilder.solidColorSelected(solidColorSelected)
            }
            drawableBuilder.solidColorDisabled(solidColorDisabled)

            val drawable = drawableBuilder
                    .build()
            setBackgroundDrawable(drawable)
        }
    }
}